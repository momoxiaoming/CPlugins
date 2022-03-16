package com.dn.encrypt

/**
 * IByteEncrypt
 *
 * @author mmxm
 * @date 2022/2/11 14:58
 */
interface IByteEncrypt {
    fun encrypt(pwd:ByteArray,value:String):ByteArray?

    fun decrypt(pwd:ByteArray,value:ByteArray):String

    fun canEncrypt(value: String):Boolean
}