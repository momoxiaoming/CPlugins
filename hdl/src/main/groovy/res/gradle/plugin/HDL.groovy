package res.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import res.gradle.plugin.task.AppAssembleTask
import res.gradle.plugin.task.PluginAssembleTask
import res.gradle.plugin.utils.AESUtils

class HDL implements Plugin<Project> {

    static String appModuleName = ""

    static String pluginAppModuleName = ""

    static String pluginAppPath = ""

    @Override
    void apply(Project project) {
        initConfig(project)
        addTask(project)
        hookTask(project)
    }

    private void initConfig(Project project){
        pluginAppModuleName=project.rootProject.modules.aos.moduleName
        pluginAppPath=project.rootProject.modules.aos.modulePath
        appModuleName=project.rootProject.main_module
        def mode=project.rootProject.AES.MODE;
        def key=project.rootProject.AES.KEY;
        def iv=project.rootProject.AES.IV;
        AESUtils.init(mode,key,iv)
    }

    /**
     * 分配任务
     * @param project
     */
    private void addTask(Project project) {
        project.allprojects { target ->
            target.afterEvaluate { pro ->
                if (pro.hasProperty("android") && pro != rootProject) {
                    addAppProguardRules(pro)
                    assembleAppTask(pro)
                    assemblePluginTask(pro)
                }
            }
        }
    }

    /**
     * 拦截任务
     * 1.拦截插件generateReleaseBuildConfig任务,插入mapping规则
     * @param project
     */
    private void hookTask(Project project) {
        project.allprojects { target ->
            target.afterEvaluate { pro ->
                Map<Project, Set<Task>> allTasks = pro.getAllTasks(true)
                for (Map.Entry<Project, Set<Task>> projectSetEntry : allTasks.entrySet()) {
                    Set<Task> value = projectSetEntry.getValue()
                    for (Task task : value) {
                        if (task.name.matches("^generate\\S*ReleaseBuildConfig\$") && pro.name == pluginAppModuleName) {
                            task.doFirst {
                                println(">> generateReleaseBuildConfig")
                            }
                            task.doLast {
                                addPluginProguardRules(pro)
                            }
                        }
                    }
                }
            }
        }
    }


    private void assembleAppTask(Project pro) {
        pro.tasks.whenTaskAdded { task ->
            //app打包后,执行拦截任务,具体见InterceptorAssembleTask
            def buildType = null
            if (task.name == "assembleDebug" && pro.name == appModuleName) {
                buildType = "Debug"
            }
            if (task.name == "assembleRelease" && pro.name == appModuleName) {
                buildType = "Release"
            }
            if (buildType != null) {
                AppAssembleTask interceptorAssembleTask = pro.tasks.create(name: "InterceptorAssembleTask${buildType}", type: AppAssembleTask)
                interceptorAssembleTask.buildType = buildType
                interceptorAssembleTask.finalizedBy(":${pluginAppPath}:assemble${buildType}")
                interceptorAssembleTask.rootProj = project
                task.finalizedBy(interceptorAssembleTask)
            }
        }
    }

    private void assemblePluginTask(Project pro) {
        pro.tasks.whenTaskAdded { task ->
            //app打包后,执行拦截任务,具体见InterceptorAssembleTask
            def buildType = null
            if (task.name == "assembleDebug" && pro.name == pluginAppModuleName) {
                buildType = "Debug"
            }
            if (task.name == "assembleRelease" && pro.name == pluginAppModuleName) {
                buildType = "Release"
            }
            if (buildType != null) {
                PluginAssembleTask pluginTask = project.tasks.create(name: "PluginTask${buildType}", type: PluginAssembleTask)
                pluginTask.buildType = buildType
                pluginTask.rootProj = project
                task.finalizedBy(pluginTask)
            }
        }
    }


    private void addAppProguardRules(Project project) {
        if (project.plugins.hasPlugin("com.android.application") && project.name == appModuleName) {
            def file = new File("${project.projectDir}")
            if (!file.exists()) {
                file.mkdirs()
            }
            def file2 = new File(file, "hdl-proguard-rules.pro")
            if (file2.exists()) {
                file2.delete()
            }
            file2.createNewFile()
            def fileStr = "-keep class androidx.databinding.**{*;}\n-keep class androidx.startup.**{*;}\n-keep class com.google.android.material.imageview.ShapeableImageView{*;}\n"
            file2.write(fileStr)

            def proguardList = new ArrayList(project.android.buildTypes.release.proguardFiles)
            proguardList.add(file2.path)
            println("proguardList-->" + file2.path)
            project.android.buildTypes.release.proguardFiles = proguardList
        }
    }

    /**
     * 添加plugin mapping
     * @param project
     */
    private void addPluginProguardRules(Project project) {
        def file = new File("${project.rootProject.projectDir}/app/build/outputs/release/mapping/mapping.txt")
        if (!file.exists()) {
            println("未找到plugin mapping--->" + file.path)
            return
        }
        def proguardList = new ArrayList(project.android.buildTypes.release.proguardFiles)
        proguardList.add(file.path)
        println("proguardList-->" + file.path)
        project.android.buildTypes.release.proguardFiles = proguardList
    }
}