package com.google.plugin

/**
 * create on 2022/5/13
 */
open class JniMessExtension {

    var enable = true

    /**
     * 配置文件路径
     */
    var configFile = ""

    var logEnable=false


    override fun toString(): String {
        return "JniMessExtension(enable=$enable, configFile='$configFile')"
    }
}