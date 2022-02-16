package com.gradle.plugin.whiteLists

import com.gradle.plugin.encrypt.EncryptInjector

/**
 * WhiteLists
 *
 * @author mmxm
 * @date 2022/1/22 18:34
 */
object WhiteLists {

    val whiteList= arrayListOf<String>()

    init {
        whiteList.add(EncryptInjector.getRuntimeEncrypt())
    }

    fun isWhiteList(className:String):Boolean{

        return true
    }
}