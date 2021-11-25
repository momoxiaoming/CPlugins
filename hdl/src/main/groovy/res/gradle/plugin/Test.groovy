package res.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

public class Test implements Plugin<Project> {


    @Override
    void apply(Project project) {
        project.allprojects { target->
            target.afterEvaluate { pro ->
                if (pro.hasProperty("android")&&pro != rootProject) {
                    pro.tasks.whenTaskAdded { task->
                        println("task--"+task.name)
                        if (task.name == "assembleDebug"&&pro.name=="app") {
                            AssetsTask assetsTask = project.tasks.create(name: "AssetsTaskDebug", type: AssetsTask)
                            task.finalizedBy(assetsTask)
                        }
                    }
                }
            }
        }

//        project.rootProject.afterEvaluate { pro->
//            println("pro--->"+pro.name)
//
//        }
    }


}