package com.plugin.stringEncrypt.encrypt



/**
 * create on 2021/9/28
 */
object Base64EncryptUtils {
    fun encrypt(bytes: ByteArray,k:Int): ByteArray {
        val hexBytes = HexEncryptUtils.encrypt(bytes,k)
        return java.util.Base64.getEncoder().encode(hexBytes)
    }
}