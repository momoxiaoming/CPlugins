package com.plugin.art

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
import com.plugin.art.utils.Common
import com.plugin.art.log.GLog
import com.plugin.art.task.CreateARouterMappingTask
import com.plugin.art.transform.AppReplaceStringTransform
import com.plugin.art.transform.LibReplaceStringTransform
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.util.*


/**
 * arouter  asm 相关字符替换, 在app下build.gradle中引入,和artOBS插件搭配使用才有效果
 *
 * @author mmxm
 * @date 2022/1/21 15:11
 */
class Art : Plugin<Project> {
    override fun apply(project: Project) {
        project.allprojects { prj->
            prj.afterEvaluate { afterPrj->
                regiest(afterPrj)
                afterPrj.tasks.whenTaskAdded {task->
                    if(task.name=="compileDebugJavaWithJavac"){
                        var interceptorAssembleTask = afterPrj.tasks.create( "${afterPrj.name}DebugARouterObsTask", CreateARouterMappingTask::class.java)
                        interceptorAssembleTask.buildType = "Debug".toLowerCase(Locale.ROOT)
                        interceptorAssembleTask.proj=afterPrj
                        task.finalizedBy(interceptorAssembleTask)
                    }
                    if(task.name=="compileReleaseJavaWithJavac"){
                        var interceptorAssembleTask = afterPrj.tasks.create( "${afterPrj.name}ReleaseARouterObsTask", CreateARouterMappingTask::class.java)
                        interceptorAssembleTask.buildType = "Release".toLowerCase(Locale.ROOT)
                        interceptorAssembleTask.proj=afterPrj
                        task.finalizedBy(interceptorAssembleTask)
                    }
                }
            }
        }


    }
    fun regiest(project: Project){
        if(project.plugins.hasPlugin("com.android.application")){
            writeProFile(project)
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

    fun writeProFile(project: Project){
        /**
         * 然后在app模块的proguard-rules.pro中写入改java文件的keep
         */
        val crFile =  File("${project.projectDir}/proguard-rules.pro")
        if (crFile.exists() && crFile.isFile) {
            val content = String(crFile.readBytes())
            val keepStr = "-keep class ${Common.keepPkg.replace("/", ".")}.**{*;}"
            if (!content.contains(keepStr)) {
                GLog.i("keepStr-->$keepStr")
                val newContent = "${content}\n$keepStr"
                crFile.writeBytes(newContent.toByteArray())
            }
        }
    }
}