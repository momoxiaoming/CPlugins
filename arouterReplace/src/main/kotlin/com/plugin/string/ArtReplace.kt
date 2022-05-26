package com.plugin.string

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
import com.plugin.string.log.GLog
import com.plugin.string.transform.AppReplaceStringTransform
import com.plugin.string.transform.LibReplaceStringTransform
import com.plugin.string.utils.Common
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File


/**
 * arouter  asm 相关字符替换, 在app下build.gradle中引入,和artOBS插件搭配使用才有效果
 *
 * @author mmxm
 * @date 2022/1/21 15:11
 */
class ArtReplace : Plugin<Project> {


    override fun apply(project: Project) {
        if(project.properties.get("isArtOBS")=="false"){
            GLog.i("ArtReplace已禁用")
            return
        }
        regiest(project)
    }
    fun regiest(project: Project){
        when (val testedExtension = project.extensions.findByType(TestedExtension::class.java)) {
            is AppExtension -> {
                testedExtension.applicationVariants
                testedExtension.registerTransform(AppReplaceStringTransform(project))
                println("registerTransform---->AppReplaceStringTransform")

            }
            is LibraryExtension -> {
                testedExtension.libraryVariants
                testedExtension.registerTransform(LibReplaceStringTransform(project))
                println("registerTransform---->LibReplaceStringTransform")
            }
            else -> {
                println("TestedExtension is null")

            }
        }
    }
}