package com.plugin.stringEncrypt.helpr

import com.plugin.stringEncrypt.encrypt.Base64EncryptUtils
import com.plugin.stringEncrypt.encrypt.HexEncryptUtils
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import kotlin.random.Random

/**
 * EncryptHelper
 *
 * @author mmxm
 * @date 2023/7/20 16:59
 */
object EncryptHelper {

    private const val BASE64_CLASS = "com/android/lib/string/decrypt/Base64DecryptUtils"
    private const val HEX_CLASS = "com/android/lib/string/decrypt/HexDecryptUtils"

    fun encrypt(mv: MethodVisitor, value: String) {
        log("加密的字符串-->" + value)
        val encryptType = listOf(0, 1)
        val key = Random.nextInt(256)
        when (encryptType.random()) {
            0 -> {
                visitDecrypt(mv, value, HEX_CLASS, key) {
                    HexEncryptUtils.encrypt(it.toByteArray(Charsets.UTF_8), key)
                }
            }
            1 -> {
                visitDecrypt(mv, value, BASE64_CLASS, key) {
                    Base64EncryptUtils.encrypt(it.toByteArray(Charsets.UTF_8), key)
                }
            }
            else -> {
                visitDecrypt(mv, value, HEX_CLASS, key) {
                    HexEncryptUtils.encrypt(it.toByteArray(Charsets.UTF_8), key)
                }
            }
        }
    }

    /**
     * 对字符串混淆并插入解密方法
     */
    private fun visitDecrypt(
        mv: MethodVisitor,
        cst: String,
        encryptClass: String,
        key: Int,
        encryptBlock: (String) -> ByteArray?
    ) {
        val byteArray = encryptBlock.invoke(cst)
        if (byteArray == null) {
            mv.visitLdcInsn(cst)
            return
        }
        mv.visitIntInsn(Opcodes.SIPUSH, byteArray.size) //申明一个数据大小
        mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE) //创建一个数组,并制定类型
        byteArray.forEachIndexed { index, byte ->
            mv.visitInsn(Opcodes.DUP)  //复制一份数组
            mv.visitIntInsn(Opcodes.SIPUSH, index) //取出对应下标
            mv.visitIntInsn(Opcodes.SIPUSH, byte.toInt()) //给数组对应下标赋值
            mv.visitInsn(Opcodes.BASTORE) //将对象存入数组指定下标
        }
        mv.visitLdcInsn(key)
        //直接将解密方法压入栈中当做常量使用
        mv.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            encryptClass,//注意这里的路径要是/,不能是,否者运行一直会有未知错误
            "decrypt",
            "([BI)Ljava/lang/String;",
            false
        )
    }

}