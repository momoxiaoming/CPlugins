package com.android.plugin.string.encrypt

/**
 * create on 2022/7/6
 */
open class StringEncryptExt {

    var enable = true
    var enableWhenDebug = false
    var encryptPackages: MutableList<String>? = null
    var logEnable = false
    override fun toString(): String {
        return "StringEncryptExt(enable=$enable, enableWhenDebug=$enableWhenDebug, encryptPackages=$encryptPackages)"
    }
}