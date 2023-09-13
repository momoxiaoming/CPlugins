package com.plugin.art.transform

import com.android.build.api.transform.*
import com.android.build.gradle.internal.pipeline.TransformManager
import com.plugin.art.ArtManager
import com.plugin.art.extension.ArtRemoveExtension
import com.plugin.art.helpr.replace.DirReplaceHelper
import com.plugin.art.helpr.replace.JarReplaceHelper
import com.plugin.art.helpr.scan.DirScanHelper
import com.plugin.art.helpr.scan.JarScanHelper
import com.plugin.art.log.GLog
import com.plugin.art.task.CreateARouterMappingTask
import org.gradle.api.Project

/**
 * 此Transform主要用于路由扫描
 *
 * @author mmxm
 * @date 2022/1/21 10:22
 */
class AScanTransform(var project: Project) : Transform() {
    companion object {
        val routes = hashMapOf<String, String>()
    }

    override fun getName(): String {
        return "art_scan";
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
        val extension = project.extensions.getByName("art_annotation") as? ArtRemoveExtension
        val openDebug = extension?.openLog ?: false
        GLog.setDebug(openDebug)

        //遍历拿出所有路由
        inputs.forEach {
            DirScanHelper.scanDir(it, output)
            JarScanHelper.scanJar(it, output)
        }

        //拿到所有路由后,处理混淆,mapp问题
        CreateARouterMappingTask.confuse(project = project, routes.keys.toList())

        //替换路由
        inputs.forEach {
            JarReplaceHelper.scanJar(it, output)
        }

        //混淆规则, 防止路由被优化
        createProguard()
    }

    fun createProguard() {
        val pgList= mutableListOf<String>()
        routes.keys.toList().forEach {
            val clz = it.replace("/", ".")
            pgList.add("-keep, allowobfuscation class $clz")
        }
        ArtManager.updateProguard(pgList)
    }
}