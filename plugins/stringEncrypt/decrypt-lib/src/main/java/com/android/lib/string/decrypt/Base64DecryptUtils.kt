package com.android.lib.string.decrypt

import android.util.Base64


/**
 * create on 2021/9/28
 */
object Base64DecryptUtils {

    @JvmStatic
    fun decrypt(src: ByteArray,k:Int): String? {
        val b64Decode = android.util.Base64.decode(src, Base64.DEFAULT)
        return HexDecryptUtils.decrypt(b64Decode,k)
    }
}