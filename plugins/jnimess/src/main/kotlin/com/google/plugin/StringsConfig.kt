package com.google.plugin

import com.google.gson.annotations.SerializedName

/**
 * create on 2022/12/6
 */
class StringsConfig {

    @SerializedName("enable")
    var enable = true

    @SerializedName("strings")
    var strings:Array<String>? = null


    override fun toString(): String {
        return "StringsConfig(enable=$enable, strings=${strings?.contentToString()})"
    }


}