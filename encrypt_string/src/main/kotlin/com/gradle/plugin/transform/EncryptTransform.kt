package com.gradle.plugin.transform

import com.android.build.api.transform.*
import com.android.build.gradle.internal.pipeline.TransformManager
import com.gradle.plugin.encrypt.EncryptInjector
import com.gradle.plugin.injector.ClassInjector
import com.gradle.plugin.log.GLog
import com.gradle.plugin.utils.eachFileRecurse
import org.gradle.api.Project
import java.io.File

/**
 * EncryptTransfrom
 *
 * @author mmxm
 * @date 2022/1/21 10:22
 */
abstract class EncryptTransform(project: Project) : Transform() {


    init {
        project.afterEvaluate {
            EncryptInjector.create(project)
        }
    }

    override fun getName(): String {
        return "string_encrypt";
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

    override fun transform(transformInvocation: TransformInvocation?) {
        super.transform(transformInvocation)
        GLog.d("---------transform")
        val inputs = transformInvocation?.inputs
        val output = transformInvocation?.outputProvider

        //首先需要删除输出的文件,使用我们后面替代的文件
        output?.deleteAll()
        //处理,并输出文件
        handleInput(inputs!!, output!!)
    }


    private fun handleInput(inputs: Collection<TransformInput>, output: TransformOutputProvider) {
        val dirOutput = output.getContentLocation("classes", outputTypes, scopes, Format.DIRECTORY)

        GLog.d("dirOutput----->${dirOutput.absolutePath}")
        inputs.forEach {
            it.directoryInputs.forEach { dit ->
                dit.file.eachFileRecurse { file ->
                    GLog.d("directoryInputs----->${file.name}")
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
                GLog.d("jarInputs----->${jarInputFile.name}-->${jarInputFile.absolutePath}")
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