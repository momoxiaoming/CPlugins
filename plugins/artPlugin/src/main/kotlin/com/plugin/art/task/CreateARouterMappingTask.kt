package com.plugin.art.task

import com.plugin.art.ArtManager
import com.plugin.art.extension.ArtRemoveExtension
import com.plugin.art.utils.Common
import org.gradle.api.Project
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.*
import kotlin.random.Random


/**
 * CreateArouterMappingTasl
 *
 * @author mmxm
 * @date 2022/5/19 17:45
 */
object CreateARouterMappingTask {
    var armFilePath = ""
    var replFilePath = ""
    var obsRouter= mutableListOf<String>()

    fun confuse(project: Project, arouterFiles: List<String>) {

        val extension = project.extensions.getByName("art_annotation") as? ArtRemoveExtension
        val openObs=extension?.openObs?:false

        val aMappingStringList= mutableListOf<String>()
        val aReplaceStringList= mutableListOf<String>()

        arouterFiles.forEach {
            val rl = it.replace("/", ".")
            val oldCls = rl
            val obsCls =
                "${oldCls.replace("\$\$${rl.split("\$\$").last()}", "\$\$")}${randomClzzName()}"
            val itemString = "$oldCls -> $obsCls"
            val itemString2 = "$oldCls -> $obsCls:"
            println(itemString)
            obsRouter.add(obsCls)
            aMappingStringList.add("\n$itemString2")
            aReplaceStringList.add("\n$itemString")
        }

        val outPath = "${project.rootDir}/app/build/"

        //写入两个文件
        /**
         * 3.在app模块目录下生成在app模块目录下生成aRouterMapping.txt,以及相应的字符串替换文件aRouterReplace.txt
         */

        val armFile = File("${outPath}/aRouterMapping.txt")
        if (!armFile.exists()) {
            armFile.createNewFile()
        }
        val replFile = File("${outPath}/aRouterReplace.txt")
        if (!replFile.exists()) {
            replFile.createNewFile()
        }
        armFile.writeText("")
        replFile.writeText("")


        armFilePath = armFile.path
        replFilePath = replFile.path



        aMappingStringList.forEach {
            Files.write(Paths.get(armFile.path), it.toByteArray(), StandardOpenOption.APPEND)
        }
        aReplaceStringList.forEach {
            Files.write(Paths.get(replFile.path), it.toByteArray(), StandardOpenOption.APPEND)
        }
        if(openObs){
            val obsFile = File("${project.rootDir}/app/obs-mapping.txt")  //为了兼容obs
            if (!obsFile.exists()) {
                obsFile.createNewFile()
            }
            val obsList=obsFile.readLines()
            aMappingStringList.forEach {
                if(!obsList.contains(it)){
                    Files.write(Paths.get(obsFile.path), it.toByteArray(), StandardOpenOption.APPEND)
                }
            }
        }else{
            ArtManager.updateProguard(listOf("-applymapping " + armFile.path))
        }
    }

    /**
     * 混淆arouter模块名或者group名
     * 随机生成5位字符串
     * @param clsName String
     */
    private fun randomClzzName(): String {
        return Common.randomClzzName(Random.nextInt(4, 8))
    }
}