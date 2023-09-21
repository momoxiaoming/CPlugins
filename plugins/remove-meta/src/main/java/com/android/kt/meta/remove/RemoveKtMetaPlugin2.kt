package com.android.kt.meta.remove

import com.android.build.api.transform.Format
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.pipeline.TransformManager
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.apache.commons.codec.digest.DigestUtils
import org.objectweb.asm.*
import java.io.File
import java.io.FileOutputStream
import java.util.jar.JarFile
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

/**
 * 删除kotlin metadata注解
 * create on 2022/5/21
 */
class RemoveKtMetaPlugin2 : Transform(), Plugin<Project> {

    private var ext: RemoveKtMetaExtension? = null

    companion object{
        const val EXT_NAME = "remove_kt_meta"
        const val TRANSFORM_NAME = "removeKtMeta"

        /**
         * 移除metadata注解
         */
        const val FLAG_REMOVE_META = 1

        /**
         * 移除Route注解
         */
        const val FLAG_REMOVE_ROUTE = 1 shl 1


    }
    fun log(msg: String) {
        if(ext?.logEnable==true){
            println("remove_kt_meta::$msg")
        }
    }
    override fun apply(project: Project) {
        log("apply")
        project.extensions.create(EXT_NAME,RemoveKtMetaExtension::class.java)
        project.extensions.getByType(AppExtension::class.java).registerTransform(this)
        project.afterEvaluate {
            ext = it.extensions.getByName(EXT_NAME) as RemoveKtMetaExtension
            log("afterEvaluate,ext=$ext")
        }
    }

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

    private fun getPkgNameFromClz(clzName: String): String {
        val index = clzName.lastIndexOf(File.separator)
        if (index == -1) {
            return clzName
        }
        return clzName.substring(0, index)
    }

    private fun getClzNameFromClassFile(filename: String): String {
        return if (filename.endsWith(".class")) filename.substring(
            0,
            filename.length - ".class".length
        ) else filename
    }

    private fun isClassNameInWhiteList(clzName: String): Boolean {
        val rawClzName = getClzNameFromClassFile(clzName)
        ext?.classWhiteList?.forEach { clz ->
            if (rawClzName == clz.replace(".","/") || rawClzName.matches(Regex(clz))) {
                return true
            }
        }
        return false
    }

    private fun getModifyFlag(clzName: String,isJarClassFlag:Boolean): Int {
        var flag = 0

        if (isNeedRemoveMeta(clzName,isJarClassFlag)) {
            flag = (flag or FLAG_REMOVE_META)
        }
        if (isNeedRemoveRoute(clzName)) {
            flag = (flag or FLAG_REMOVE_ROUTE)
        }
        return flag
    }

    private fun isNeedRemoveRoute(clzName: String): Boolean {
        if (!clzName.endsWith(".class")) {
            log("$clzName is not class file,do not modify")
            return false
        }
        val pkgName = getPkgNameFromClz(clzName)
        ext?.scanRoutePackages?.forEach { pkg ->
            val cPkg = pkg.replace(".","/")
            if (cPkg == pkgName || (ext?.includeSubPkgs == true && pkgName.contains(cPkg)) || pkgName.matches(Regex(pkg))) {
                log("pkg:$pkgName need remove Route")
                return true
            }
        }
        return false
    }

    private fun isNeedRemoveMeta(clzName: String,isJarClassFlag:Boolean): Boolean {
        if (!clzName.endsWith(".class")) {
            log("$clzName is not class file,do not modify")
            return false
        }
        val pkgName = getPkgNameFromClz(clzName)
        ext?.scanPackages?.forEach { pkg ->
            var cPkg:String? = null
            if(isJarClassFlag) {
                cPkg = if(isWindows()) {
                    pkg.replace(".","/")
                } else {
                    pkg.replace(".",File.separator)
                }
            } else {
                cPkg = pkg.replace(".",File.separator)
            }
            //val cPkg = pkg.replace(".","/")
            if (cPkg == pkgName || (ext?.includeSubPkgs == true && pkgName.contains(cPkg)) || pkgName.matches(Regex(pkg))) {
                if (isClassNameInWhiteList(clzName)) {
                    log("$clzName is in whitelist,do not modify")
                } else {
                    log("pkg:$pkgName need remove meta")
                    return true
                }
            }
        }
        return false
    }

    private fun isWindows():Boolean {
        return org.gradle.internal.os.OperatingSystem.current().isWindows
    }

    private fun isLinux():Boolean {
        return org.gradle.internal.os.OperatingSystem.current().isLinux
    }

    private fun doModifyClass(name:String,oriBytes:ByteArray,flag:Int):ByteArray?{
        val cr = ClassReader(oriBytes)
        val cw = ClassWriter(cr, ClassWriter.COMPUTE_MAXS)
        val cv = RemoveSomethingClassVisitor(name,cw,flag)
        cr.accept(cv, ClassReader.EXPAND_FRAMES)
        return cw.toByteArray()
    }

    private inner class RemoveSomethingClassVisitor(val _name:String, cv:ClassVisitor,val flag:Int):ClassVisitor(Opcodes.ASM9,cv){

        override fun visitAnnotation(desc: String?, visible: Boolean): AnnotationVisitor? {
            return when (desc) {
                "Lkotlin/Metadata;" -> {
                    if ((flag and FLAG_REMOVE_META) != 0) {
                        log("Removed @Metadata annotation from $_name")
                        null
                    } else {
                        super.visitAnnotation(desc, visible)
                    }
                }
                "Lkotlin/coroutines/jvm/internal/DebugMetadata;" -> {
                    if ((flag and FLAG_REMOVE_META) != 0) {
                        log("Removed @DebugMetadata annotation from $_name")
                        null
                    } else {
                        super.visitAnnotation(desc, visible)
                    }
                }
                "Lcom/alibaba/android/arouter/facade/annotation/Route;"->{
                    if ((flag and FLAG_REMOVE_ROUTE) != 0) {
                        log("Removed @Route from $_name")
                        null
                    } else {
                        super.visitAnnotation(desc, visible)
                    }
                }
                else -> {
                    super.visitAnnotation(desc, visible)
                }
            }
        }
    }

    private fun modifyClassIfNeeded(clzFile: File, dir: File) {
        if (!clzFile.name.endsWith(".class")) {
            log("modifyClassIfNeeded,file=${clzFile.path},not class file,return")
            return
        }
        var clzName = clzFile.path.substring(dir.path.length)
        if (clzName.first() == File.separatorChar) {
            clzName = clzName.substring(1)
        }
        val flag = getModifyFlag(clzName,false)
        if (flag!=0) {
            doModifyClass(clzName,clzFile.readBytes(),flag)?.let { newBytes ->
                val fos = FileOutputStream(clzFile.path)
                fos.write(newBytes)
                fos.flush()
                fos.close()
            }
            log("$clzName modify done")
        }
    }

    private fun modifyJarIfNeeded(oriJarPath: File, destJar: File) {
        val destFos = ZipOutputStream(FileOutputStream(destJar))
        val oriJarFile = JarFile(oriJarPath)
        val entries = oriJarFile.entries()
        while (entries.hasMoreElements()) {
            val entry = entries.nextElement()
            val zis = oriJarFile.getInputStream(entry)
            val oriBytes = IOUtils.toByteArray(zis)
            destFos.putNextEntry(ZipEntry(entry.name))
            val flag = getModifyFlag(entry.name,true)
            if (flag == 0) {
                destFos.write(oriBytes, 0, oriBytes.size)
            } else {
                val newBytes = doModifyClass(entry.name, oriBytes, flag) ?: oriBytes
                destFos.write(newBytes, 0, newBytes.size)
            }
            zis.close()
        }
        destFos.flush()
        destFos.close()
    }

    override fun transform(transformInvocation: TransformInvocation) {
        var enable = ext?.enable ?: false
        log("transform,ext.enable=$enable")
        if(enable){
            val isReleaseBuild = transformInvocation.context.variantName.toLowerCase().contains("release")
            if (!isReleaseBuild && ext?.enable_WhenDebug == false) {
                log("transform,not release build and ext.enable_WhenDebug=false")
                enable = false
            }
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
                    dirInput.file.eachFileRecurse {file ->
                        modifyClassIfNeeded(file,dirInput.file)
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
                val includeJar = ext?.includeJar ?: false
                log("includeJar=$includeJar")
                if (enable && includeJar) {
                    modifyJarIfNeeded(jarInput.file, destJar)
                } else {
                    FileUtils.copyFile(jarInput.file, destJar)
                }
            }
        }
    }
}