package com.android.plugins


import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * AESUtils
 *
 * @author mmxm
 * @date 2021/11/4 17:10
 */
object AESUtils {

    private val MODE = "AES/CBC/PKCS5Padding" //加密模式

    private val TRANSFORMATION = "AES"

    private val DEFULT_PASSWORD = BuildConfig.aes_key  //和copyPlugin.gradle定义一致


    private val IV = BuildConfig.aes_iv.padEnd(16).toByteArray()


    private val cipher by lazy {
        Cipher.getInstance(MODE)
    }

    private val secretKeySpec by lazy {
        SecretKeySpec(DEFULT_PASSWORD.toByteArray(), TRANSFORMATION)
    }

    /**
     * AES加密
     *
     * @param pwd 密码必须为16位或者32位,也就是16个字母或者32个字母
     * @param content 加密的字符串
     * @return
     */
    fun encrypt(content: String): ByteArray? {
        try {
            // 创建AES秘钥
            // 初始化加密器
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, IvParameterSpec(IV))
            val bt: ByteArray = cipher.doFinal(content.toByteArray(charset("UTF-8")))
            return bt
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }


    /**
     * AES解密
     * @param pwd 密码必须为16位或者32位,也就是16个字母或者32个字母
     * @param content 加密的字符串
     * @return
     * @throws Exception
     */

    fun decrypt(content: ByteArray): ByteArray? {

        try {
            val input = content
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, IvParameterSpec(IV))
            // 解密
            val bt: ByteArray = cipher.doFinal(input)
            return bt
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }


    /**
     * 将二进制转16进制字符串
     * @param buf
     * @return
     */
     fun parseByte2HexStr(buf: ByteArray?): String {
        try {
            if(buf==null){
                throw Exception("buf is null")
            }
            val sb = StringBuffer()
            for (i in buf.indices) {
                var hex = Integer.toHexString(buf[i].toInt() and 0xFF)
                if (hex.length == 1) {
                    hex = "0$hex"
                }
                sb.append(hex.toUpperCase())
            }
            return sb.toString()
        } catch (e: Exception) {
            throw e
        }
    }

    /**
     * 将16进制转换为二进制
     * @param hexStr
     * @return
     */
     fun parseHexStr2Byte(hexStr: String?): ByteArray {
        try {
            if(hexStr==null){
                throw Exception("hexStr is null")
            }
            val result = ByteArray(hexStr.length / 2)
            for (i in 0 until hexStr.length / 2) {
                val high = hexStr.substring(i * 2, i * 2 + 1).toInt(16)
                val low = hexStr.substring(i * 2 + 1, i * 2 + 2).toInt(16)
                result[i] = (high * 16 + low).toByte()
            }
            return result
        } catch (e: Exception) {
            throw e
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {

    }
}

