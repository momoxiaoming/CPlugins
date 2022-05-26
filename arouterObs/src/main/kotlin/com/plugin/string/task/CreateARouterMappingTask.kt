package com.plugin.string.task

import com.plugin.string.log.GLog
import com.plugin.string.utils.Common
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.lang.StringBuilder
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


        /**
         * 3.在app模块目录下生成在app模块目录下生成aRouterMapping.txt,以及相应的字符串替换文件aRouterReplace.txt
         * aRouterMapping: com.alibaba.android.arouter.routes.ARouter$$Group$$test -> com.alibaba.android.arouter.routes.ARouter$$Group$$test_xxx
         * aRouterReplace: com.alibaba.android.arouter.routes.ARouter$$Group$$test -> com.alibaba.android.arouter.routes.ARouter$$Group$$test_xxx:
         */
        val armFile = File("${proj.rootDir}/app/aRouterMapping.txt")
        if (!armFile.exists()) {
            armFile.createNewFile()
        }

        val replFile = File("${proj.rootDir}/app/aRouterReplace.txt")
        if (!replFile.exists()) {
            replFile.createNewFile()
        }
        val armContent = StringBuilder(armFile.readText())
        val replContent = StringBuilder(replFile.readText())

        arouterFiles.forEach {
            val oldCls = it
            val obsCls = "${oldCls.replace(it.split("\$\$").last(), "")}${randomClzzName()}"
            val itemString = "$oldCls -> $obsCls"
            val itemString2 = "$oldCls -> $obsCls:"
            replContent.append("\n$itemString")
            armContent.append("\n$itemString2")
        }
        //写入两个文件
        armFile.writeBytes(armContent.toString().toByteArray())
        replFile.writeBytes(replContent.toString().toByteArray())

//        /**
//         * 在各自模块keep arouter临时类
//         */
//        val pg=if(proj.name=="app"){
//            //
//            File("${proj.rootDir}/app/proguard-rules.pro")
//        }else{
//            File("${proj.projectDir}/consumer-rules.pro")
//        }
//        if (pg.exists() && pg.isFile) {
//            val content = String(pg.readBytes())
//            val keepStr = "-keep class ${Common.keepPkg.replace("/", ".")}.$keepFileName{*;}"
//            if (!content.contains(keepStr)) {
//                val newContent = "${content}\n$keepStr"
//                pg.writeBytes(newContent.toByteArray())
//            }
//        }


        /**
         * 最后一步,将aRouterMapping写入到app模块下的proguard-rules.pro中
         * 新增通用keep
         * -keep class com.alibaba.android.arouter.routes.ARouter$$Root$$arouterapi
           -keep class com.alibaba.android.arouter.routes.ARouter$$Providers$$arouterapi
           -keep class com.alibaba.android.arouter.routes.ARouter$$Group$$arouter
         */
        val pgFile = File("${proj.rootDir}/app/proguard-rules.pro")
        val addSt="-applymapping "+armFile.path
        val pgCt=StringBuffer(pgFile.readText())
        val us1="-keep class com.alibaba.android.arouter.routes.ARouter\$\$Root\$\$arouterapi"
        val us2="-keep class com.alibaba.android.arouter.routes.ARouter\$\$Providers\$\$arouterapi"
        val us3="-keep class com.alibaba.android.arouter.routes.ARouter\$\$Group\$\$arouter"


        if(!pgCt.contains(us1)){
            pgCt.append("\n$us1")
        }
        if(!pgCt.contains(us2)){
            pgCt.append("\n$us2")
        }
        if(!pgCt.contains(us3)){
            pgCt.append("\n$us3")
        }

        if(!pgCt.contains(addSt)){
            pgCt.append("\n$addSt")
        }




        pgFile.writeBytes(pgCt.toString().toByteArray())

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