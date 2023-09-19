package com.plugin.ads

import com.android.build.gradle.AppExtension
import com.plugin.ads.extension.AssetsObsExtension
import com.plugin.ads.extension.ExtensionManager
import com.plugin.ads.log.GLog
import com.plugin.ads.transform.AssetsObsTransform
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File


/**
 * 注解移除
 *
 * @author mmxm
 * @date 2022/1/21 15:11
 */
class Ads : Plugin<Project> {
    override fun apply(project: Project) {
        regiest(project)
        hookAssetsTask(project)
    }

    private fun regiest(project: Project) {
        project.extensions.create("assets_file_obs", AssetsObsExtension::class.java)
        if (project.plugins.hasPlugin("com.android.application")) {
            val appExtension = project.extensions.findByType(AppExtension::class.java)
            appExtension?.registerTransform(AssetsObsTransform(project))
        }
    }

    private fun hookAssetsTask(project: Project) {
        println("assets obs 任务开始")
        project.afterEvaluate {
            ExtensionManager.initExtension(it)
            it.tasks.forEach { task ->
                if (task.name.matches(Regex("^merge\\S*ReleaseAssets\$"))) {
                    task.doLast { assetTask ->
                        assetTask.outputs.files.forEach { file ->
                            GLog.i("assets输出文件->"+file.path)
                            if (file.path.contains("assets")) {
                                /**
                                 * 这里顺序别错了, 优先重命名文件,再重命名目录, 否者会出现问题
                                 */
                                renameFile(file)
                                renameDir(file)
                            }
                        }
                    }
                }
            }
        }
    }

    fun renameFile(targetFile: File?) {
        val list = ExtensionManager.getObsFile()
        if (list.isNullOrEmpty()) return
        println("替换assets资源文件,需要替换的文件路径:$list")
        val allFile = arrayListOf<File>()
        listFilesRecursively(targetFile, allFile)
        println("已找到assets下文件个数:${allFile.size}")
        rename(list,allFile)
    }

    fun renameDir(targetFile: File) {
        val list = ExtensionManager.getObsDir()
        if (list.isNullOrEmpty()) return
        println("替换assets资源目录, 需要替换的目录路径: ${list}")
        val allFile = arrayListOf<File>()
        listDirRecursively(targetFile, allFile)
        println("已找到assets下目录个数:${allFile.size}")
        rename(list,allFile)
    }

    private fun rename(list:List<String>,allFile:ArrayList<File>){
        /**
         * 这里循环list,不循环allfile的原因主要是好控制顺序,防止一些存在上下级关系的文件目录需要混
         */
        list.forEach {
            val file= allFile.find {outFile-> outFile.path.endsWith(it) }
            if(file!=null){
                val obsName=ExtensionManager.getObsName(it)
                if(obsName.isNullOrEmpty()){
                    println("obs name is empty")
                    return
                }
                val newFile = File(file.path.replace(it, obsName))
                GLog.i("it:$it--->${file.path}---rename-->${newFile.path}")
                file.renameTo(newFile)
                ExtensionManager.setUseName(it,obsName)
            }else{
                println("不存在文件或目录需要替换:$it ")
            }
        }
    }
    /**
     * 获取一个目录下的所有文件
     * @param directory File?
     * @param list ArrayList<File>
     */
    private fun listFilesRecursively(directory: File?, list: ArrayList<File>): ArrayList<File> {
        // 获取目录下的所有文件
        directory?.listFiles()?.forEach { file ->
            if (file.isFile) {
                // 如果是文件，输出文件名
                list.add(file)
            } else if (file.isDirectory) {
                // 如果是目录，递归调用该方法
                listFilesRecursively(file, list)
            }
        }
        return list
    }

    /**
     * 获取一个目录的所有目录
     * @param directory File?
     * @param list ArrayList<File>
     */
    private fun listDirRecursively(directory: File?, list: ArrayList<File>): ArrayList<File> {
        // 获取目录下的所有文件
        directory?.listFiles()?.forEach { file ->
           if (file.isDirectory) {
                // 如果是目录
                list.add(file)
                listDirRecursively(file, list)
            }
        }
        return list
    }

}