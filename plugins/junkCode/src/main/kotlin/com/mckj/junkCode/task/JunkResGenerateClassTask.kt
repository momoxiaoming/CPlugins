package com.mckj.junkCode.task

import com.mckj.junkCode.ext.ExtensionManager
import com.mckj.junkCode.templates.res.DrawableTemplate
import com.mckj.junkCode.templates.res.LayoutTemplate
import com.mckj.junkCode.templates.res.StyleTemplate
import com.mckj.junkCode.util.Helper
import com.mckj.junkCode.util.logI
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File
import kotlin.random.Random

/**
 * 随机生成垃圾类
 * 1. 记录生成的垃圾res, 并输出表单用于keep
 *
 * @author mmxm
 * @date 2023/7/11 9:35
 */
open class JunkResGenerateClassTask : DefaultTask() {

    @Input
    lateinit var resDir: File

    @TaskAction
    fun doTask() {
        println("JunkResGenerateClassTask do task")
        if (!resDir.exists()) {
            resDir.mkdirs()
        }

        //生成垃圾资源
        generateResource()
    }




    /**
     * 生成资源
     */
    private fun generateResource() {
        val keepList= mutableListOf<String>()
        /**
         * 生成drawable
         */
        val drawableCount =getRandomForArray(ExtensionManager.extension?.maxDrawableResCount, 2, 50)

        for (i in 0..drawableCount) {
            val fileName=Helper.randomLengthName()
            writeResFile(File(resDir,"drawable/${fileName}.xml"),DrawableTemplate.randomTemplate())
            keepList.add("@drawable/$fileName")
        }
        logI("随机drawableCount个数:$drawableCount")

        /**
         * 生成string
         */
        val stringResCount =getRandomForArray(ExtensionManager.extension?.maxStringResCount, 2, 50)
        val stringFile=File(resDir,"value/string.xml")
        val sb=StringBuilder()
        sb.append("<resources>\n")
        for (i in 0..stringResCount) {
            sb.append("<string name=\"${Helper.randomLengthName(5,20)}\">${Helper.randomLengthName()}</string>\n")
        }
        sb.append("</resources>\n")
        writeResFile(stringFile,sb.toString())
        logI("随机生成string个数:$stringResCount")

        /**
         * 生成layout
         */
        val layoutResCount =getRandomForArray(ExtensionManager.extension?.maxLayoutResCount, 2, 50)
        for (i in 0..layoutResCount) {
            val fileName=Helper.randomLengthName()
            writeResFile(File(resDir,"layout/$fileName.xml"), LayoutTemplate.randomTemplate())
            keepList.add("@layout/$fileName")
        }

        /**
         * 生成color
         */
        val colorResCount =getRandomForArray(ExtensionManager.extension?.maxColorResCount, 2, 50)
        val colorFile=File(resDir ,"value/colors.xml")
        val colorSb=StringBuilder()
        colorSb.append("<resources>\n")
        for (i in 0..colorResCount) {
            colorSb.append("<color name=\"${Helper.randomLengthName(5,20)}\">${Helper.randomColor()}</color>\n")
        }
        colorSb.append("</resources>\n")
        writeResFile(colorFile,colorSb.toString())
        logI("随机colorResCount个数:$drawableCount")


        /**
         * 生成样式
         */
        val styleResCount =getRandomForArray(ExtensionManager.extension?.maxStyleResCount, 2, 50)
        val styleFile=File(resDir,"value/styles.xml")
        val styleSb=StringBuilder()
        styleSb.append("<resources>\n")
        for (i in 0..styleResCount) {
            styleSb.append(StyleTemplate.randomTemplate())
        }
        styleSb.append("</resources>\n")
        writeResFile(styleFile,styleSb.toString())
        logI("随机styleResCount个数:$styleResCount")


        /**
         * 生成资源keep文件,存放在res/raw/keep.xml下
         */
        val keepFile=File(resDir,"raw/keep.xml")
        val keepSb=StringBuilder()
        keepSb.append("<resources\n ")
        keepSb.append("xmlns:tools=\"http://schemas.android.com/tools\"\n")
        var keepStr="tools:keep=\""
        keepList.forEach {
            keepStr+= "$it, "
        }
        keepSb.append("$keepStr\"\n")
        keepSb.append("/>")
        writeResFile(keepFile,keepSb.toString())
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




    private fun getRandomForArray(array: IntArray?, min: Int, max: Int): Int {
        return if (array != null && array.size == 2) {
            Random.nextInt(array[0], array[1])
        } else {
            Random.nextInt(min, max)
        }
    }
}