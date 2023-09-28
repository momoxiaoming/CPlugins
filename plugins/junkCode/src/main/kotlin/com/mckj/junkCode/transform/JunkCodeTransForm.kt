package com.mckj.junkCode.transform

import com.android.build.api.transform.*
import com.android.build.gradle.internal.pipeline.TransformManager
import com.mckj.junkCode.ext.ExtensionManager
import com.mckj.junkCode.helper.DirReplaceHelper
import com.mckj.junkCode.helper.JarHelper

/**
 * JunkCodeTransForm
 *
 * @author mmxm
 * @date 2023/7/11 11:57
 */
class JunkCodeTransForm : Transform() {
    override fun getName(): String {
        return "JunkCode"
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
            JarHelper.scanJar(it, output)

            ExtensionManager.updateProguard(ExtensionManager.transFromProdList)

        }
    }
}