package com.android.lib.string.decrypt

import org.apache.commons.codec.binary.Base64


/**
 * create on 2021/9/28
 */
object Base64DecryptUtils {

    @JvmStatic
    fun decrypt(src: ByteArray,k:Int): String {
        val b64Decode = Base64.decodeBase64(src)
        return HexDecryptUtils.decrypt(b64Decode,k)
    }
}