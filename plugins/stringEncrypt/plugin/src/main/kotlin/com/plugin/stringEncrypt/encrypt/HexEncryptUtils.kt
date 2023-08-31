package com.plugin.stringEncrypt.encrypt

import kotlin.experimental.xor

/**
 * HexEncryptUtils
 *
 * @author mmxm
 * @date 2023/7/20 17:50
 */
object HexEncryptUtils {

    fun encrypt(bytes: ByteArray?, keys: Int): ByteArray? {
        if (bytes == null) {
            return null
        }
        val len = bytes.size
        var key = keys * keys * keys shl 1
        var pos: Int
        for (i in 0 until len) {
            pos = if (i % 2 == 0) {
                i * i shr 1
            } else {
                i * i * i shr 1
            }
            key = key xor pos
            bytes[i] = (bytes[i].toInt() xor key).toByte()
            key = bytes[i].toInt()
        }
        return bytes
    }
}