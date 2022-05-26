package com.plugin.string


import com.plugin.string.log.GLog
import com.plugin.string.task.CreateARouterMappingTask
import com.plugin.string.utils.Common
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.util.*

/**
 * 放在根目录build下,用于找出所有arouter生成的临时文件
 *
 * @author mmxm
 * @date 2022/1/21 15:11
 */
class ArtOBS : Plugin<Project> {
    override fun apply(project: Project) {
        if(project.properties.get("isArtOBS")=="false"){
            GLog.i("artObs已禁用")
            return
        }
        project.allprojects { prj->
            prj.afterEvaluate { afterPrj->
                if (afterPrj.name == "app") {
                    clearDir(afterPrj)
                    writeProFile(afterPrj)
                }
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

    fun clearDir(project: Project){
        val armFile = File("${project.rootDir}/app/aRouterMapping.txt")
        if(armFile.exists()){
            armFile.delete()
        }
        val arrFile = File("${project.rootDir}/app/aRouterReplace.txt")
        if(arrFile.exists()){
            arrFile.delete()
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