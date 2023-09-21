package com.google.plugin

import com.google.gson.annotations.SerializedName

/**
 * create on 2022/12/6
 */
class ManifestConfig {

    @SerializedName("enable")
    var enable = true

    /**
     * manifest中需要随机化的串以及对应需要同步修改的类
     */
    @SerializedName("manifestObsItems")
    var manifestObsItems:List<ManifestObsInfo>? = null


    override fun toString(): String {
        return "ManifestConfig(enable=$enable, manifestObsItems=$manifestObsItems)"
    }


}