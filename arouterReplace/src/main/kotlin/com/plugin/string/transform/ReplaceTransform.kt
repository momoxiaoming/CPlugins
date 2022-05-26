package com.plugin.string.transform

import com.android.build.api.transform.*
import com.android.build.gradle.internal.pipeline.TransformManager
import com.android.utils.FileUtils
import com.plugin.string.encrypt.EncryptInjector
import com.plugin.string.utils.eachFileRecurse
import org.apache.commons.codec.digest.DigestUtils
import org.gradle.api.Project
import java.io.File

/**
 * ReplaceTransform
 *
 * @author mmxm
 * @date 2022/1/21 10:22
 */
abstract class ReplaceTransform(project: Project) : Transform() {


    init {
        EncryptInjector.create(project)
    }

    override fun getName(): String {
        return "replace_string";
    }

    /**
     * Transform 的输入类型,一般是class文件
     * @return MutableSet<QualifiedContent.ContentType>
     */
    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> {
        return TransformManager.CONTENT_CLASS
    }

    /**
     * 输入文件支持的范围
     * @return MutableSet<in QualifiedContent.Scope>
     */
    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    /**
     * 是否支持增量编译
     * @return Boolean
     */
    override fun isIncremental(): Boolean {
        return false
    }
//
//    override fun transform(
//        context: Context?,
//        inputs: MutableCollection<TransformInput>?,
//        referencedInputs: MutableCollection<TransformInput>?,
//        outputProvider: TransformOutputProvider?,
//        isIncremental: Boolean
//    ) {
//        if (!isIncremental) {
//            outputProvider?.deleteAll()
//        }
//        inputs?.forEach { input ->
//            input.jarInputs.forEach { jarInput ->
//                var destName = jarInput.name
//                val hexName = DigestUtils.md5Hex(jarInput.file.absolutePath)
//                if (hexName.endsWith(".jar")) {
//                    destName = destName.substring(0, destName.length() - 4)
//                }
//                //input file
//                val src = jarInput.file
//                // output file
//                val dest = outputProvider?.getContentLocation(
//                    destName + "_" + hexName,
//                    jarInput.contentTypes,
//                    jarInput.scopes,
//                    Format.JAR
//                )
//                //scan jar file to find classes
//                EncryptInjector.injector.doJumpClass(src, dest!!)
//                FileUtils.copyFile(src, dest)
//            }
//
//            input.directoryInputs.forEach { directoryInput ->
//                val dest = outputProvider!!.getContentLocation(
//                    directoryInput.name,
//                    directoryInput.contentTypes,
//                    directoryInput.scopes,
//                    Format.DIRECTORY
//                )
//                var root = directoryInput.file.absolutePath
//                if (!root.endsWith(File.separator))
//                    root += File.separator
//
//                directoryInput.file.eachFileRecurse { file ->
//
//                    //开始处理class
//                    if (file.name.endsWith(".class")) {
//                        //交给stringClassVisitor处理class
//                        EncryptInjector.injector.doJumpClass(file, fileOutput)
//                    }
//                }
//                FileUtils.copyDirectory(directoryInput.file, dest)
//            }
//        }
//    }

    override fun transform(transformInvocation: TransformInvocation?) {
        super.transform(transformInvocation)
        val inputs = transformInvocation?.inputs
        val output = transformInvocation?.outputProvider

        //首先需要删除输出的文件,使用我们后面替代的文件
        output?.deleteAll()
        //处理,并输出文件
        handleInput(inputs!!, output!!)
    }


    private fun handleInput(inputs: Collection<TransformInput>, output: TransformOutputProvider) {
        inputs.forEach {
            it.directoryInputs.forEach { dit ->
                val dirOutput = output.getContentLocation("classes", outputTypes, scopes, Format.DIRECTORY)
                dit.file.eachFileRecurse { file ->
                    val fileOutput = File(
                        file.absolutePath.replace(
                            dit.file.absolutePath,
                            dirOutput.absolutePath
                        )
                    )
                    if (!fileOutput.parentFile.exists()) {
                        fileOutput.parentFile.mkdirs()
                    }
                    if (!fileOutput.exists()) {
                        fileOutput.createNewFile()
                    }
                    //开始处理class
                    if (file.name.endsWith(".class")) {
                        //交给stringClassVisitor处理class
                        EncryptInjector.injector.doJumpClass(file, fileOutput)
                    } else {
                        //无需处理,直接输出
                        fileOutput.writeBytes(file.readBytes())
                    }
                }
            }
            it.jarInputs.forEach { jarInput ->
                val jarInputFile = jarInput.file
                val jarOutputFile =
                    output.getContentLocation(jarInputFile.name, outputTypes, scopes, Format.JAR)
                if (!jarInputFile.parentFile.exists()) {
                    jarInputFile.parentFile.mkdirs()
                }
                if (jarInput.status == Status.REMOVED) {
                    if (jarInputFile.exists()) {
                        jarInputFile.delete()
                    }
                } else {
                    EncryptInjector.injector.doJumpJar(jarInputFile, jarOutputFile)
                }
            }
        }
    }

}