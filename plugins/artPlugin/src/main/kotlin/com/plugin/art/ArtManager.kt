package com.plugin.art

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
        if (buildProguardFile ==null) {
            return
        }
        if (!buildProguardFile!!.exists()) {
            var lines = ""
            proguard.forEach {
                lines += "\n $it"
            }
            buildProguardFile!!.writeText(lines)
        } else {
            var proguard = buildProguardFile!!.readText()
            proguard.forEach {
                proguard += "\n $it"
            }
            buildProguardFile!!.writeText(proguard)
        }
    }



}