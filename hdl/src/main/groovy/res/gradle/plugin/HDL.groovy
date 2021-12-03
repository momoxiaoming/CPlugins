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
        println("HDL,插件脚本允许运行")
        initConfig(project)
        addTask(project)
        hookTask(project)

    }

    private void initConfig(Project project) {
        pluginAppModuleName = project.rootProject.modules.aos.moduleName
        pluginAppPath = project.rootProject.modules.aos.modulePath
        appModuleName = project.rootProject.main_module
        def mode = project.rootProject.AES.MODE;
        def key = project.rootProject.AES.KEY;
        def iv = project.rootProject.AES.IV;
        AESUtils.init(mode, key, iv)
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
                    addPluginMappingRules(pro)
                    getBuildSign(pro)
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
                        if (task.name.matches("^generate\\S*ReleaseBuildConfig\$") && pro.name == appModuleName) {
                            task.doFirst {
                                println(">> generateReleaseBuildConfig")
                            }
                            task.doLast {
//                                getBuildSign(pro)
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取签名
     * @param pro
     */
    private void getBuildSign(Project project) {
        if (project.plugins.hasPlugin("com.android.application") && project.name == appModuleName) {
            def signingConfig = project.android.buildTypes.release.signingConfig
            if(signingConfig!=null&&signingConfig.storeFile!=null){
                println("sign--->${signingConfig.storeFile.path}")
                println("sign--->${signingConfig.storePassword}")
                println("sign--->${signingConfig.keyAlias}")
                println("sign--->${signingConfig.keyPassword}")

                Constans.sign_storeFile_path=signingConfig.storeFile.path
                Constans.sign_storePassword=signingConfig.storePassword
                Constans.sign_keyPassword=signingConfig.keyPassword
                Constans.sign_keyAlias=signingConfig.keyAlias

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
                AppAssembleTask interceptorAssembleTask = pro.tasks.create(name: "AppAssembleTask${buildType}", type: AppAssembleTask)
                interceptorAssembleTask.buildType = buildType
                interceptorAssembleTask.finalizedBy(":${pluginAppPath}:assemble${buildType}")
                interceptorAssembleTask.rootProj = pro
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
            def file = new File("${project.rootProject.projectDir}", "app/build/hdl/proguard")
            if (!file.exists()) {
                file.mkdirs()
            }
            def file2 = new File(file, "hdl-proguard-rules.pro")
            if (file2.exists()) {
                file2.delete()
            }
            file2.createNewFile()
            def fileStr = "${project.rootProject.main_proguard}"
            file2.write(fileStr)

            def proguardList = new ArrayList(project.android.buildTypes.release.proguardFiles)
            proguardList.add(file2.path)
            project.android.buildTypes.release.proguardFiles = proguardList
        }
    }

    /**
     * 添加plugin mapping
     * 1.引用hdl-proguard-rules.pro文件,并追加mapping
     * @param project
     */
    private void addPluginMappingRules(Project project) {
        //
        println("添加aos插件pro")
        if (project.plugins.hasPlugin("com.android.application") && project.name == pluginAppModuleName) {
            def proguard = new File("${project.rootProject.projectDir}", "app/build/hdl/proguard/hdl-proguard-rules.pro")
            if (!proguard.exists()) {
                throw Exception("${proguard.path}文件未生成,请检查")
            }
            def proguard2 = new File("${project.rootProject.projectDir}", "app/build/hdl/proguard/hdl-${pluginAppModuleName}-proguard-rules.pro")
            if (proguard2.exists()) {
                proguard2.delete()
            }
            proguard2.createNewFile()
            def mappingFile = new File("${project.rootProject.projectDir}/app/build/hdl/mapping/mapping.txt")
//            if (!mappingFile.exists()) {
//                throw Exception("未找到plugin mapping")
//            }
            proguard2.withDataOutputStream {
                it.write("${project.rootProject.modules.aos.proguard}".getBytes())
                it.write("-applymapping  ${mappingFile.path}\n".getBytes())
            }

            def proguardList = new ArrayList(project.android.buildTypes.release.proguardFiles)
            proguardList.add(proguard2.path)
            println("proguardList-->" + proguard2.path)
            project.android.buildTypes.release.proguardFiles = proguardList
        }


    }
}