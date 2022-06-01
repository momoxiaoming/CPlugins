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
open class CreateARouterMappingTask : DefaultTask() {



    @Input
    lateinit var proj: Project


    @Input
    lateinit var buildType: String


    @TaskAction
    open fun confuse() {
        val arouterPath = "com/alibaba/android/arouter/routes"
        val kaptDir = "${proj.buildDir}/generated/source/kapt/$buildType"
        val files = File("${kaptDir}/$arouterPath")
        GLog.i("arouter kapt path-->${files.path}")

        val arouterFiles = mutableListOf<String>()
        files.listFiles()?.forEach {
            val path = "${arouterPath.replace("/", ".")}.${it.name.replace(".java", "")}"
            arouterFiles.add(path)
        }
        GLog.i("arouterFiles-->${arouterFiles.size}")
        if (arouterFiles.size == 0) {
            return
        }
        val keepPkg = Common.keepPkg
        val keepFileName = randomClzzName()
        val outFilePath = File("${proj.buildDir}/intermediates/javac/${buildType}/classes/$keepPkg")
        if (!outFilePath.exists()) {
            outFilePath.mkdirs()
        }
        val keepFile = File(outFilePath, "$keepFileName.class")
        if (keepFile.exists()) {
            keepFile.delete()
        }
        keepFile.createNewFile()

        //1.拿到所有arouter文件之后,新增一个java文件用于防keep
        GLog.i("crtCls-->${keepFile.path}")

        EncryptClassGenerator.createDefaultEncrypt(
            keepFileName,
            keepPkg.replace("/", "."), arouterFiles, keepFile
        )

        arouterFiles.forEach {
            val oldCls = it
            val obsCls = "${oldCls.replace(it.split("\$\$").last(), "")}${randomClzzName()}"
            val itemString = "$oldCls -> $obsCls"
            val itemString2 = "$oldCls -> $obsCls:"
            Common.aMappingStringList.add("\n$itemString2")
            Common.aReplaceStringList.add("\n$itemString")
        }
        //写入两个文件

        if(proj.pluginManager.hasPlugin("com.android.application")){

            /**
             * 3.在app模块目录下生成在app模块目录下生成aRouterMapping.txt,以及相应的字符串替换文件aRouterReplace.txt
             */
            val armFile = File("${proj.rootDir}/app/aRouterMapping.txt")
            if (!armFile.exists()) {
                armFile.createNewFile()
            }

            val replFile = File("${proj.rootDir}/app/aRouterReplace.txt")
            if (!replFile.exists()) {
                replFile.createNewFile()
            }
            armFile.writeText("")
            replFile.writeText("")

            Common.aMappingStringList.forEach {
                Files.write(Paths.get(armFile.path), it.toByteArray(), StandardOpenOption.APPEND)
            }
            Common.aReplaceStringList.forEach {
                Files.write(Paths.get(replFile.path), it.toByteArray(), StandardOpenOption.APPEND)
            }

            /**
             * 最后一步,将aRouterMapping写入到app模块下的proguard-rules.pro中
             * 新增通用keep
             * -keep class com.alibaba.android.arouter.routes.ARouter$$Root$$arouterapi
            -keep class com.alibaba.android.arouter.routes.ARouter$$Providers$$arouterapi
            -keep class com.alibaba.android.arouter.routes.ARouter$$Group$$arouter
             */
            val pgFile = File("${proj.rootDir}/app/proguard-rules.pro")
            val pgCt=StringBuffer(pgFile.readText())
            val us= listOf<String>(
                "-keep class com.alibaba.android.arouter.routes.ARouter\$\$Root\$\$arouterapi\n"
                ,"-keep class com.alibaba.android.arouter.routes.ARouter\$\$Providers\$\$arouterapi\n"
                ,"-keep class com.alibaba.android.arouter.routes.ARouter\$\$Group\$\$arouter\n"
                ,"-keep class ${Common.keepPkg.replace("/", ".")}.**{*;}\n")
            val addSt="-applymapping "+armFile.path
            us.forEach {
                if(!pgCt.contains(it)){
                    Files.write(Paths.get(pgFile.path), it.toByteArray(), StandardOpenOption.APPEND)
                }
            }
//          if(!pgCt.contains(addSt)){  //特殊版本,去掉applymapping
//            pgCt.append("\n$addSt")
//        }
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
        return Common.randomClzzName(Random.nextInt(4,8))
    }
}