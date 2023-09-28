package com.plugin.art

import com.plugin.art.log.GLog
import java.io.File

/**
 * ArtManager
 *
 * @author mmxm
 * @date 2023/9/12 11:41
 */
object ArtManager {

    /**
     * 记录build中progurad file的路径
     */
    var buildProguardFile: File? = null


    /**
     * 更新proGuard,防止修改的mapping被优化
     */
    fun updateProguard(proguard: List<String>) {
        if (buildProguardFile == null) {
            throw Exception("art->buildProguardFile not found")
        }
        if(!buildProguardFile!!.exists()){
            buildProguardFile!!.createNewFile()
        }
        val lineList= mutableListOf<String>()
        lineList.addAll(buildProguardFile!!.readLines())

        proguard.forEach {
            lineList.add("$it")
        }
        val fileText=StringBuilder()
        lineList.forEach {
            GLog.i("lineList, item->$it")
            fileText.append("$it\n")
        }
        buildProguardFile!!.writeText(fileText.toString())
    }

}