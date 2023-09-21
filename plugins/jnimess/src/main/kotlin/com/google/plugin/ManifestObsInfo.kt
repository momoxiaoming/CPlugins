package com.google.plugin

import com.google.gson.annotations.SerializedName

/**
 * 混淆manifest中的字符串，同步修改对应class中的字符串
 * create on 2022/11/17
 */
class ManifestObsInfo {

    /**
     * 需要随机化的字符串
     */
    @SerializedName("str")
    var str: String = ""

    /**
     * 对应需要同步修改的类
     */
    @SerializedName("clzList")
    var clzList:Array<String>? = null


    override fun toString(): String {
        return "ManifestObsInfo(str='$str', clzList=${clzList?.contentToString()})"
    }


}