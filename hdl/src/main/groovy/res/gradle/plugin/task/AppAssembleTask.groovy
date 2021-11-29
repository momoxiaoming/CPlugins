package res.gradle.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import res.gradle.plugin.HDL

/**
 * app打包后,执行此任务
 * 1.找出最终的mapping 相关文件
 * 2.根据现有mapping,合并出插件需要的mapping文件
 * 3.执行插件编译任务
 * 4.将app生成的apk,通过重编译,将插件apk置于assets下
 * 5.输出最终的宿主apk
 */
public class AppAssembleTask extends DefaultTask {
    @Input
    String rootProj
    @Input
    String buildType


    @TaskAction
    void confuse() {
        if(buildType.toLowerCase()=="debug"){
            //跳过合并阶段

        }else{
            //开始合并mapping
//            mergeMapping()
        }

    }


    /**
     * 合并mapping
     * @return
     */
    private File mergeMapping() {
        def mappingFile = new File(project.buildDir + "/outputs/mapping/${buildType.toLowerCase()}/mapping.txt")
        def seedFile = new File(project.buildDir + "/outputs/mapping/${buildType.toLowerCase()}/seeds.txt")

        //合并
        
        return null
    }
    /**
     * 生成apk
     */
    private void assemblePluginApk() {
        def pluginTask=project.tasks.findByName(":${HDL.pluginAppPath}:assemble${buildType.toUpperCase()}")
        finalizedBy(pluginTask)
    }



}