package com.mckj.junkCode.ext

import com.mckj.junkCode.util.logI
import org.gradle.api.Project
import java.io.File

/**
 * JunkCodeExtension
 *
 * @author mmxm
 * @date 2023/7/7 18:23
 */
object ExtensionManager {

    val extensionTagName = "junkCodeExtension"

    var extension: JunkCodeExtension? = null

    /**
     * 记录下混淆文件
     */
    var proguardFile:File?=null

    /**
     * 通过任务生成的规则
     */
    var taskProdList= mutableListOf<String>()


    /**
     * 通过transFrom生成的规则
     */
    var transFromProdList= mutableListOf<String>()
    fun initExtension(project: Project) {
        extension = project.extensions.getByName(extensionTagName) as JunkCodeExtension
    }


    fun getRomManifestNodeNum(): Int {
        return extension?.maxManifestJunkNodeNum ?: 0
    }

    /**
     * 更新proGuard,防止修改的mapping被优化
     */
    fun updateProguard(proguard: List<String>) {
        if (proguardFile == null) {
            throw Exception("junkcode->buildProguardFile not found")
        }
        if (!proguardFile!!.exists()) {
            proguardFile!!.createNewFile()
        }
        val lineList = mutableListOf<String>()
        lineList.addAll(proguardFile!!.readLines())
        proguard.forEach {
            lineList.add("$it")
        }
        val fileText = StringBuilder()
        lineList.forEach {
            logI("lineList, item->$it")
            fileText.append("$it\n")
        }
        proguardFile!!.writeText(fileText.toString())
    }

}