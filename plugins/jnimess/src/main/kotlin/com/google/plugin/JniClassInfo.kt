package com.google.plugin

import com.google.gson.annotations.SerializedName

/**
 * create on 2022/5/14
 */
class JniClassInfo {

    /**
     * so文件名
     */
    @SerializedName("soName")
    var soName = ""

    /**
     * 调用loadLib的class
     */
    @SerializedName("loadSoClzName")
    var loadSoClzName = ""

    /**
     * 需要混淆native方法的类名
     */
    @SerializedName("clzName")
    var clzName = ""

    /**
     * native方法名数组
     */
    @SerializedName("nativeMethods")
    var nativeMethods:Array<String>? = null

    /**
     * 引用了需要混淆的jni类的类列表
     */
    @SerializedName("refClasses")
    var refClasses:Array<String>? = null

}