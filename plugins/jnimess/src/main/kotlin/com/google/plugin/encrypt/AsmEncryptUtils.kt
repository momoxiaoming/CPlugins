package com.google.plugin.encrypt

import com.google.plugin.JniMessPlugin
import com.google.plugin.encrypt.algorithm.Base64EncryptUtils
import com.google.plugin.encrypt.algorithm.HexEncryptUtils
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Opcodes.*
import kotlin.random.Random

/**
 * create on 2021/9/27
 */
object AsmEncryptUtils {

    private const val AGL_HEX = 1
    private const val HEX_CLASS = "com/android/lib/string/decrypt/HexDecryptUtils"
    private const val HEX_METHOD = "decrypt"

    private const val AGL_BASE64 = 2
    private const val BASE64_CLASS = "com/android/lib/string/decrypt/Base64DecryptUtils"
    private const val BASE64_METHOD = "decrypt"

    private val AGL_LIST = listOf(
        AGL_HEX,
        AGL_BASE64
    )

    fun encryptDecrypt(mv: MethodVisitor, value: String) {
        val agl = AGL_LIST[Random.nextInt(AGL_LIST.size)]
        when (agl) {
            AGL_HEX -> {
                hexEncryptDecrypt(mv, value)
            }
            AGL_BASE64 -> {
                base64EncryptDecrypt(mv, value)
            }
        }
    }

    private fun base64EncryptDecrypt(mv: MethodVisitor, value: String) {
        val k = Random.nextInt(256)
        val encryptResult = Base64EncryptUtils.encrypt(value.toByteArray(Charsets.UTF_8), k)
        JniMessPlugin.log("b64 encrypt,$value->$encryptResult")

        mv.visitIntInsn(Opcodes.SIPUSH, encryptResult.size)
        mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE)
        for(i in encryptResult.indices){
            mv.visitInsn(Opcodes.DUP)
            mv.visitIntInsn(Opcodes.SIPUSH, i)
            mv.visitIntInsn(Opcodes.BIPUSH, encryptResult[i].toInt())
            mv.visitInsn(Opcodes.BASTORE);
        }
        mv.visitLdcInsn(k)
        mv.visitMethodInsn(
            INVOKESTATIC,
            BASE64_CLASS,
            BASE64_METHOD,
            "([BI)Ljava/lang/String;",
            false
        )
    }

    private fun hexEncryptDecrypt(mv: MethodVisitor, value: String) {
        val k = Random.nextInt(256)
        val encryptResult = HexEncryptUtils.encrypt(value.toByteArray(Charsets.UTF_8), k)
        mv.visitIntInsn(Opcodes.SIPUSH, encryptResult.size)
        mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE)
        for(i in encryptResult.indices){
            mv.visitInsn(Opcodes.DUP)
            mv.visitIntInsn(Opcodes.SIPUSH, i)
            mv.visitIntInsn(Opcodes.BIPUSH, encryptResult[i].toInt())
            mv.visitInsn(Opcodes.BASTORE);
        }
        mv.visitLdcInsn(k)
        mv.visitMethodInsn(
            INVOKESTATIC,
            HEX_CLASS,
            HEX_METHOD,
            "([BI)Ljava/lang/String;",
            false
        )
    }
}