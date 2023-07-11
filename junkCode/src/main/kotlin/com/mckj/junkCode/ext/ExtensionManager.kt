package com.mckj.junkCode.ext

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
     * 存放映射关系的类
     */
    var mappingMap= mutableListOf<String>()

    fun initExtension(project: Project) {
        extension = project.extensions.getByName(extensionTagName) as JunkCodeExtension
    }


    fun getRomManifestNodeNum(): Int {
        return extension?.maxManifestJunkNodeNum ?: 0
    }


    /**
     * 更新混淆文件,主要用于asm垃圾代码添加完毕, keep垃圾方法
     */
    fun updateProguardFile(){
        if(proguardFile?.exists()==true){
            var lines=""
            ExtensionManager.mappingMap.forEach {
                lines+="\n $it"
            }
            proguardFile!!.writeText(lines)
        }
    }

}