package com.plugin.art.task

import com.plugin.art.utils.Common
import com.plugin.art.log.GLog
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.lang.StringBuilder
import java.nio.file.Files
import java.nio.file.Path
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

        val aMappingStringList= mutableListOf<String>()
        val aReplaceStringList= mutableListOf<String>()

        arouterFiles.forEach {
            val rl = it.replace("/", ".")
            val oldCls = rl
            val obsCls =
                "${oldCls.replace("\$\$${rl.split("\$\$").last()}", "\$\$")}${randomClzzName()}"
            val itemString = "$oldCls -> $obsCls"
            val itemString2 = "$oldCls -> $obsCls:"
            GLog.i(itemString)
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
        if (armFile.exists()) {
            armFile.delete()

        }
        val replFile = File("${outPath}/aRouterReplace.txt")
        if (replFile.exists()) {
            replFile.delete()
        }
        armFile.createNewFile()
        replFile.createNewFile()
        armFilePath = armFile.path
        replFilePath = replFile.path

        aMappingStringList.forEach {
            Files.write(Paths.get(armFile.path), it.toByteArray(), StandardOpenOption.APPEND)
        }
        aReplaceStringList.forEach {
            Files.write(Paths.get(replFile.path), it.toByteArray(), StandardOpenOption.APPEND)
        }

        /**
         * 最后一步,将aRouterMapping写入到app模块下的proguard-rules.pro中
         * 新增通用keep
         */
        val pgFile = File("${project.rootDir}/app/proguard-rules.pro")
        val addSt = "-applymapping " + armFile.path
        val pgCt = StringBuffer(pgFile.readText())
        val us = listOf<String>(
            "\n-keep class ${Common.keepPkg.replace("/", ".")}.**{*;}\n",
            "$addSt\n"

        )

        us.forEach {
            if (!pgCt.contains(it)) {
                Files.write(Paths.get(pgFile.path), it.toByteArray(), StandardOpenOption.APPEND)
            }
        }


        /**

         */


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