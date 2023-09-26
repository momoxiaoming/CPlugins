package com.google.plugin.encrypt.algorithm



/**
 * create on 2021/9/28
 */
object Base64EncryptUtils {

    fun encrypt(bytes: ByteArray,k:Int): ByteArray {
        val hexBytes = HexEncryptUtils.encrypt(bytes,k)
        return org.apache.commons.codec.binary.Base64.encodeBase64(hexBytes)
    }
}