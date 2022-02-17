package com.gradle.plugin

/**
 * ByteEncrypt
 *
 * @author mmxm
 * @date 2022/1/25 14:16
 */
open class ByteEncryptExtension {
    var key: String? = null
    var debug: Boolean = false
    var encryptImplCls: String? = null
    var encryptPackages: Array<String>? = null
}