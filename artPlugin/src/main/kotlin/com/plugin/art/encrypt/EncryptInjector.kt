package com.plugin.art.encrypt



import com.plugin.art.log.GLog
import com.plugin.art.task.CreateARouterMappingTask
import org.gradle.api.Project
import java.io.File


/**
 * EncryptInjector
 *
 * @author mmxm
 * @date 2022/1/24 11:10
 */
object EncryptInjector {

    fun readMappingFile(): List<Pair<String, String>> {
        val list = mutableListOf<Pair<String, String>>()
        val mappingPath= CreateARouterMappingTask.replFilePath
        if (mappingPath.isNotEmpty()) {
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
        GLog.i("mappingPath-->${list.size}")
        return list
    }


}