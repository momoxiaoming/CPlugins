package com.plugin.art

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
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
        project.allprojects { prj->
            prj.afterEvaluate { afterPrj->
                regiest(afterPrj)
                afterPrj.tasks.forEach { task->
                    task.doLast {
                        it.inputs.files.forEach {
                            GLog.i("task: inputs:${task.name}---${it.path}")
                        }
                        it.outputs.files.forEach {
                            GLog.i("task: outputs:${task.name}---${it.path}")
                        }
                    }
                }
//                afterPrj.tasks.whenTaskAdded {task->
//                    if(task.name=="compileDebugJavaWithJavac"){
//                        var interceptorAssembleTask = afterPrj.tasks.create( "${afterPrj.name}DebugARouterObsTask", CreateARouterMappingTask::class.java)
//                        interceptorAssembleTask.buildType = "Debug".toLowerCase(Locale.ROOT)
//                        interceptorAssembleTask.proj=afterPrj
//                        task.finalizedBy(interceptorAssembleTask)
//                    }
//                    if(task.name=="compileReleaseJavaWithJavac"){
//                        var interceptorAssembleTask = afterPrj.tasks.create( "${afterPrj.name}ReleaseARouterObsTask", CreateARouterMappingTask::class.java)
//                        interceptorAssembleTask.buildType = "Release".toLowerCase(Locale.ROOT)
//                        interceptorAssembleTask.proj=afterPrj
//                        task.finalizedBy(interceptorAssembleTask)
//                    }
//                }
            }
        }


    }
    fun regiest(project: Project){
        if(project.plugins.hasPlugin("com.android.application")){
            val appExtension = project.extensions.findByType(AppExtension::class.java)
            appExtension?.registerTransform(AScanTransform(project))
            appExtension?.registerTransform(ReplaceTransform(project))
        }
    }
}