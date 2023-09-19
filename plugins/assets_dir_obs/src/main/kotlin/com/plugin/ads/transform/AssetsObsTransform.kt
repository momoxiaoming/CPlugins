package com.plugin.ads.transform

import com.android.build.api.transform.*
import com.android.build.gradle.internal.pipeline.TransformManager
import com.plugin.ads.extension.ExtensionManager
import com.plugin.ads.helpr.replace.DirReplaceHelper
import com.plugin.ads.helpr.replace.JarHelper
import org.gradle.api.Project
import java.lang.Exception

/**
 * 此Transform主要用于路由替换以及注解删除
 *
 * @author mmxm
 * @date 2022/1/21 10:22
 */
class AssetsObsTransform(var project: Project) : Transform() {

    override fun getName(): String {
        return "assetsObs";
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
        }
        //检查assets修改的路径和替换的字符串是否能匹配
        if(ExtensionManager.useMapping.keys.size!=0){
            throw Exception("修改的assets文件目录路径与修改的字符串不匹配,请检查:${ExtensionManager.useMapping.keys.toList()}")
        }
    }
}