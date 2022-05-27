package com.plugin.string.string

import com.plugin.string.encrypt.EncryptInjector
import java.io.File

/**
 * ReplaceStringManager
 * 字符串替换管理类
 *
 * @author mmxm
 * @date 2022/5/17 17:08
 */
object ReplaceStringManager : IReplaceString {

    var sMap = hashMapOf<String, String>()

    init {
        EncryptInjector.readMappingFile().forEach {
            sMap[it.first]=it.second
        }
    }

    override fun replace(string: String): String {
//        println("replace  $string")
        val value = sMap[string]
       return if(value!=null){
            println("replace-string  $string to $value")
            value
        }else{
            string
        }

    }
}