package com.google.plugin

import com.google.gson.annotations.SerializedName

/**
 * 随机化java类中的字符串
 * create on 2022/12/6
 */
class JavaStringConfig {

    @SerializedName("enable")
    var enable = true

    @SerializedName("list")
    var list:Array<JavaStringInfo>? = null


    override fun toString(): String {
        return "JavaStringConfig(enable=$enable, list=${list?.contentToString()})"
    }


}