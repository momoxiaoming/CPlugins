package com.android.kt.meta.remove

/**
 * create on 2022/5/21
 */
open class RemoveKtMetaExtension {

    var enable = true

    /**
     * 日志开关
     */
    var logEnable=false
    /**
     * debug包是否修改
     */
    var enable_WhenDebug = false

    /**
     * 扫描的包名列表，支持正则表达式
     */
    var scanPackages: Array<String>? = null

    /**
     * 与scanPackages对应，是否扫描子包
     */
    var includeSubPkgs = true

    /**
     * 类名白名单，支持正则表达式
     */
    var classWhiteList:Array<String>? = null

    /**
     * 是否修改jar包
     */
    var includeJar = true

    /**
     * 扫描aroute Route注解的类，支持正则表达式
     */
    var scanRoutePackages:Array<String>? = null

    /**
     * 是否移除arouter Route注解
     */
    var removeRouteAnnotation = false

    override fun toString(): String {
        return "RemoveKtMetaExtension(enable=$enable, enable_WhenDebug=$enable_WhenDebug, scanPackages=${scanPackages?.contentToString()}, includeSubPkgs=$includeSubPkgs, classWhiteList=${classWhiteList?.contentToString()}, includeJar=$includeJar, scanRoutePackages=${scanRoutePackages?.contentToString()}, removeRouteAnnotation=$removeRouteAnnotation)"
    }
}