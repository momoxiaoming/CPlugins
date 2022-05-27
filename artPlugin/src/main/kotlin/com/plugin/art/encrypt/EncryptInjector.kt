package com.plugin.string.encrypt



import org.gradle.api.Project
import java.io.File


/**
 * EncryptInjector
 *
 * @author mmxm
 * @date 2022/1/24 11:10
 */
object EncryptInjector {

    /**
     * 替换的类的映射文件地址
     */
    private var mappingPath: String ?=null


    fun create(project: Project) {
        mappingPath="${project.rootDir}/app/aRouterReplace.txt"
    }


    fun readMappingFile(): List<Pair<String, String>> {
        val list = mutableListOf<Pair<String, String>>()
        if (!mappingPath.isNullOrEmpty()) {
            val file = File(mappingPath!!)
            file.readLines().forEach {
                val sp = it.split("->")
                if (sp.size > 1) {
                    val key = sp[0].trim()
                    val value = sp[1].trim()
                    list.add(Pair(key, value))
                }
            }
        }
        return list
    }


}