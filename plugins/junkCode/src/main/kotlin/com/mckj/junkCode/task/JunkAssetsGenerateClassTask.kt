package com.mckj.junkCode.task

import com.mckj.junkCode.ext.ExtensionManager
import com.mckj.junkCode.ext.randomForArray
import com.mckj.junkCode.templates.res.DrawableTemplate
import com.mckj.junkCode.templates.res.LayoutTemplate
import com.mckj.junkCode.templates.res.StyleTemplate
import com.mckj.junkCode.util.Helper
import com.mckj.junkCode.util.logI
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.util.Base64
import kotlin.random.Random

/**
 * 随机生成垃圾assets文件
 *
 * @author mmxm
 * @date 2023/7/11 9:35
 */
object JunkAssetsGenerateClassTask  {

    fun doTask(resDir: File) {
        println("JunkAssetsGenerateClassTask do task")
        if (!resDir.exists()) {
            resDir.mkdirs()
        }
        //生成垃圾文件
        generateAssets(resDir)
    }




    /**
     * 生成资源
     */
    private fun generateAssets(resDir: File) {
        /**
         * 生成文件夹数量
         */
        val dirCount = randomForArray(ExtensionManager.extension?.maxAssetsDirCount)
        logI("assets dir random count :$dirCount")

        for (i in 0 until  dirCount) {
            val dirName=Helper.randomLengthName()
            val dirPath=resDir.path+File.separator+dirName
            val dirFileCount = randomForArray(ExtensionManager.extension?.maxAssetsDirFileCount)
            for (j in 0..dirFileCount){
                logI("assets dir :$dirName, file random count:$dirFileCount")
                val fileName=Helper.randomLengthName()
                val min=ExtensionManager.extension?.maxAssetFileSize?.first()?:0
                val max=ExtensionManager.extension?.maxAssetFileSize?.last()?:0
                if(max<min || max<=0){
                    break
                }
                val content=Base64.getEncoder().encodeToString(Helper.randomLengthName(min,max).toByteArray())
                writeResFile2(File(dirPath,fileName),content)
            }
        }
    }
    private fun writeResFile(file: File,str:String){
        if(!file.parentFile.exists()){
            file.parentFile.mkdirs()
        }
        if(!file.exists()){
            file.createNewFile()
        }
        file.writeText(str)

    }

    private fun writeResFile2(file: File,str:String){
        if(!file.parentFile.exists()){
            file.parentFile.mkdirs()
        }
        if(!file.exists()){
            file.createNewFile()
        }
        file.writeBytes(str.toByteArray())

    }
}