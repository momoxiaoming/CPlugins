package com.mckj.annotation.utlis

object Logger {
    //    private lateinit var logger: org.gradle.api.logging.Logger
    private  var TAG = "Plugin::Transform >>> "

    fun make(tag: String) {
        TAG = tag
    }

    fun i(info: String) {
        println(TAG + info)
    }

    fun e(error: String) {
        println(TAG + error)
    }

    fun w(warning: String) {
        println(TAG + warning)
    }
}