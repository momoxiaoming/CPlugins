package com.plugin.ads.extension

import org.gradle.api.Project
import java.io.File
import java.lang.StringBuilder
import javax.lang.model.SourceVersion
import kotlin.random.Random

/**
 * ExtensionUtils
 *
 * @author mmxm
 * @date 2022/8/3 12:17
 */
object ExtensionManager {
    private var mappingName = HashMap<String, String>()

    /**
     * 此map主要用于检查任务是否异常, 所有替换是否生效
     * 比如asset文件路径已改,但是未找到代码响应的字符串, 这里就会留下标记
     */
    var useMapping = HashMap<String, String>()


    var extension: AssetsObsExtension? = null


    fun initExtension(project: Project) {
        extension = project.extensions.getByName("assets_file_obs") as AssetsObsExtension
        initMappingName()
    }

    private fun initMappingName() {
        getObsFile()?.forEach {
            val fileName = if (it.contains("\\")) {
                it.split("\\").last()
            } else {
                it
            }
            val path = it.replace(fileName, "")
            if (fileName.contains(".")) {
                val hz = it.split(".")[1]
                mappingName[it] = "$path${randomName()}.$hz"
            } else {
                mappingName[it] = "$path${randomName()}"
            }
        }
        getObsDir()?.forEach {
            val fileName = if (it.contains("\\")) {
                it.split("\\").last()
            } else {
                it
            }
            val path = it.replace(fileName, "")
            mappingName[it] = "$path${randomName()}"
        }
    }

    fun getObsFile(): List<String>? {
        return extension?.assetsFileObs?.keys?.toList()?.map {
            it.replace("/", "\\")
        }?.sortedByDescending { it }
    }

    fun getObsDir(): List<String>? {
        return extension?.assetsDirObs?.keys?.toList()?.map {
            it.replace("/", "\\")
        }?.sortedByDescending { it }
    }

    /**
     * 获取混淆后的名字
     * @param oldName String
     * @return String?
     */
    fun getObsName(oldName: String): String? {
        return mappingName[oldName]
    }

    fun setUseName(oldName: String, newName: String) {
        useMapping[oldName] = newName
    }

    fun getUseName(oldName: String): String? {
        return if(oldName.contains("/")){
            val key=oldName.replace("/","\\")
            val rlt=useMapping[key]?.replace("\\","/")
            if(rlt!=null){
                useMapping.remove(key)
            }
            rlt
        }else{
            val rlt=useMapping[oldName]
            if(rlt!=null){
                useMapping.remove(oldName)
            }
            rlt
        }


    }

    /**
     * 获取所有已经更改文件夹路径的类
     * @return ArrayList<String>
     */
    fun getAssetStringClass(): ArrayList<String> {
        val listCls = arrayListOf<String>()
        useMapping.keys.map { it.replace("\\", "/") }.forEach {
            extension?.assetsDirObs?.get(it)?.let { lst ->
                listCls.addAll(lst)
            }
            extension?.assetsFileObs?.get(it)?.let { lst ->
                listCls.addAll(lst)
            }
        }
        return listCls
    }


    /**
     * 混淆arouter模块名或者group名
     * 随机生成5位字符串
     * @param clsName String
     */
    private fun randomName(num: Int = 8): String {
        var clzz: String
        do {
            clzz = romdomClzz(num)
        } while (SourceVersion.isKeyword(clzz))
        return clzz
    }

    private fun romdomClzz(num: Int = 8): String {
        val clzz = StringBuilder()
        for (i in 0 until num) {
            val rlt = Random.nextInt(97, 123)
            clzz.append(rlt.toChar())
        }
        return clzz.toString()

    }
}