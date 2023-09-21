package com.android.plugin.string.encrypt

import com.android.build.api.transform.Format
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.pipeline.TransformManager
import com.android.plugin.string.encrypt.utils.eachFileRecurse
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import java.io.File
import java.io.FileOutputStream
import java.util.*
import java.util.jar.JarFile
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

/**
 * create on 2022/7/5
 */
class StringEncryptPlugin1 : Transform(), Plugin<Project> {

    companion object{
        const val EXT_NAME = "encrypt_string"
        const val TRANSFORM_NAME = "stringEncrypt"

        fun log(msg: String) {
            println("stringEncryptPlugin::$msg")
        }
    }

    private var ext: StringEncryptExt? = null

    override fun getName(): String {
        return TRANSFORM_NAME
    }

    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> {
        return TransformManager.CONTENT_CLASS
    }

    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    override fun isIncremental(): Boolean {
        return false
    }

    override fun apply(project: Project) {
        log("apply")
        project.dependencies.add("implementation", "com.vi.security:stringEncryptTool:2.0.6")
        project.extensions.create(EXT_NAME, StringEncryptExt::class.java)
        project.extensions.getByType(AppExtension::class.java).registerTransform(this)
        project.afterEvaluate {
            ext = it.extensions.getByType(StringEncryptExt::class.java)
            log("afterEvaluate,ext=$ext")
        }
    }

    private fun modifyClass(name:String,bytes: ByteArray?): ByteArray? {
        log("modifyClass,name=$name")
        bytes ?: return null
        return try {
            val cr = ClassReader(bytes)
            val cw = ClassWriter(cr, ClassWriter.COMPUTE_MAXS)
            val cv = EncryptStringClassVisitor(cw)
            cr.accept(cv, ClassReader.EXPAND_FRAMES)
            cw.toByteArray() ?: bytes
        } catch (e: Throwable) {
            e.printStackTrace()
            log("modifyClass failed,name=$name")
            null
        }
    }

    private fun isClassNeedModify(name:String):Boolean{
        ext?.encryptPackages?.forEach { pkg ->
            if (name.contains(pkg.replace(".", File.separator))) {
                log("$name need modify-string-encrypt")
                return true
            }
        }
        return false
    }

    /**
     * 修改单个class文件
     * @return 修改后的class文件(可能与原class文件类名不一样）
     */
    private fun modifyClassIfNeeded(dir: File, file: File) {
        if (!file.name.endsWith(".class")) {
            log("modifyClassIfNeeded,file=${file.path},not class file,return")
            return
        }
        var clzName = file.path.substring(dir.path.length)
        if (clzName.first() == File.separatorChar) {
            clzName = clzName.substring(1)
        }
        if (!isClassNeedModify(clzName)) {
            return
        }
        modifyClass(file.path,file.readBytes())?.let { bytes ->
            val fos = FileOutputStream(file.path)
            fos.write(bytes)
            fos.flush()
            fos.close()
        }
    }

    /**
     * 修改jar包
     */
    private fun modifyJarIfNeeded(oriJarPath: File, destJar: File) {
        log("modifyJarIfNeeded,file=${oriJarPath.path},dest=${destJar.path}")
        val destFos = ZipOutputStream(FileOutputStream(destJar))
        val oriJarFile = JarFile(oriJarPath)
        val entries = oriJarFile.entries()
        while (entries.hasMoreElements()) {
            val entry = entries.nextElement()
            val isNeedModify = isClassNeedModify(entry.name)
            val zis = oriJarFile.getInputStream(entry)
            val oriBytes = IOUtils.toByteArray(zis)
            destFos.putNextEntry(ZipEntry(entry.name))
            if (isNeedModify) {
                val newBytes = modifyClass(entry.name,oriBytes)
                val toWriteBytes = newBytes ?: oriBytes
                destFos.write(toWriteBytes, 0, toWriteBytes.size)
            } else {
                destFos.write(oriBytes, 0, oriBytes.size)
            }
            zis.close()
        }
        destFos.flush()
        destFos.close()
    }

    override fun transform(transformInvocation: TransformInvocation) {
        super.transform(transformInvocation)
        val isReleaseBuild = transformInvocation.context.variantName.toLowerCase(Locale.ROOT).contains("release")
        var enable = ext?.enable ?: false
        if (!enable) {
            log("transform,ext.enable=false,disable")
        }
        if (!isReleaseBuild && ext?.enableWhenDebug == false) {
            log("transform,not release build,disable")
            enable = false
        }
        val outputProvider = transformInvocation.outputProvider
        if (!isIncremental) {
            outputProvider?.deleteAll()
        }

        if (outputProvider == null) {
            log("outputProvider is null !!!!")
            return
        }
        transformInvocation.inputs?.forEach {
            it.directoryInputs.forEach { dirInput ->
                val destDir = outputProvider.getContentLocation(
                    dirInput.name,
                    dirInput.contentTypes,
                    dirInput.scopes,
                    Format.DIRECTORY
                )
                if (enable) {
                    dirInput.file.eachFileRecurse { file ->
                        modifyClassIfNeeded(dirInput.file, file)
                    }
                }
                FileUtils.copyDirectoryToDirectory(dirInput.file,destDir)
            }
            it.jarInputs.forEach { jarInput ->
                var destName = jarInput.file.name
                val hexName = DigestUtils.md5Hex(destName).substring(0,8)
                if (destName.endsWith(".jar")) {
                    destName = destName.substring(0, destName.length - 4)
                }
                val destJar = outputProvider.getContentLocation(
                    destName + "_" + hexName,
                    jarInput.contentTypes,
                    jarInput.scopes,
                    Format.JAR
                )
                log("transform jar,ori=${jarInput.file.path},dest=${destJar.path}")
                if (!destJar.exists()) {
                    try {
                        destJar.createNewFile()
                    } catch (e: Throwable) {
                        log("modifyJarIfNeeded,create dest jar failed")
                    }
                }
                if (!destJar.exists()) {
                    throw java.lang.IllegalStateException("modifyJarIfNeeded,create dest jar failed")
                }
                if (enable) {
                    modifyJarIfNeeded(jarInput.file, destJar)
                } else {
                    FileUtils.copyFile(jarInput.file, destJar)
                }
            }
        }
    }
}