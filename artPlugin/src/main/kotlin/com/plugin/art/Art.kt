package com.plugin.art

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
import com.plugin.art.extension.ArtRemoveExtension
import com.plugin.art.log.GLog
import com.plugin.art.task.CreateARouterMappingTask
import com.plugin.art.transform.AScanTransform
import com.plugin.art.transform.ReplaceTransform
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.util.*


/**
 * arouter  asm 相关字符替换, 在app下build.gradle中引入,和artOBS插件搭配使用才有效果
 *
 * @author mmxm
 * @date 2022/1/21 15:11
 */
class Art : Plugin<Project> {
    override fun apply(project: Project) {
        regiest(project)
    }
    fun regiest(project: Project){
        project.extensions.create("art_annotation", ArtRemoveExtension::class.java)
        if(project.plugins.hasPlugin("com.android.application")){
            val appExtension = project.extensions.findByType(AppExtension::class.java)
            appExtension?.registerTransform(AScanTransform(project))
            appExtension?.registerTransform(ReplaceTransform(project))
        }
    }
}