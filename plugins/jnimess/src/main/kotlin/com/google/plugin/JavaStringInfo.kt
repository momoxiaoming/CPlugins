package com.google.plugin

import com.google.gson.annotations.SerializedName

/**
 * create on 2022/11/17
 */
class JavaStringInfo {

    @SerializedName("clzName")
    var clzName:String = ""

    @SerializedName("strings")
    var strings:Array<String>? = null

    override fun toString(): String {
        return "JavaStringInfo(clzName='$clzName', strings=${strings?.contentToString()})"
    }


}