package com.google.plugin.encrypt.algorithm

import com.google.plugin.encrypt.utils.Base64


/**
 * create on 2021/9/28
 */
object Base64EncryptUtils {

    fun encrypt(bytes: ByteArray,k:Int): ByteArray {
        val hexBytes = HexEncryptUtils.encrypt(bytes,k)
        return Base64.encode(hexBytes,Base64.DEFAULT)
    }
}