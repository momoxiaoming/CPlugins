package com.plugin.reann.transform

import com.android.build.api.transform.*
import com.android.build.gradle.internal.pipeline.TransformManager
import com.plugin.reann.extension.ExtensionManager
import com.plugin.reann.helpr.replace.DirReplaceHelper
import com.plugin.reann.helpr.replace.JarReplaceHelper
import org.gradle.api.Project

/**
 * 此Transform主要用于路由替换以及注解删除
 *
 * @author mmxm
 * @date 2022/1/21 10:22
 */
class AnnRemoveTransform(var project: Project) : Transform() {

    init {
        project.afterEvaluate {
            ExtensionManager.initExtension(it)
        }
    }

    override fun getName(): String {
        return "AnnRemoveTransform";
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
        val inputs = transformInvocation?.inputs
        val output = transformInvocation?.outputProvider
        //首先需要删除输出的文件,使用我们后面替代的文件
        output?.deleteAll()
        //处理,并输出文件
        handleInput(inputs!!, output!!)
    }


    private fun handleInput(inputs: Collection<TransformInput>, output: TransformOutputProvider) {
        inputs.forEach {
            DirReplaceHelper.scanDir(it, output)
            JarReplaceHelper.scanJar(it, output)
        }

    }

}