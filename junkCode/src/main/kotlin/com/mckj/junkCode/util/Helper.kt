package com.mckj.junkCode.util

import org.objectweb.asm.Opcodes
import java.lang.StringBuilder
import javax.lang.model.SourceVersion
import kotlin.random.Random

/**
 * Helper
 *
 * @author mmxm
 * @date 2023/7/10 11:17
 */
object Helper {
    val ACC_LIST = arrayOf(Opcodes.ACC_PRIVATE, Opcodes.ACC_PUBLIC, Opcodes.ACC_PROTECTED)
    val ACC_LIST1 = arrayOf(Opcodes.ACC_STATIC, Opcodes.ACC_FINAL)
    val DESC_LIST = arrayOf("Ljava/lang/String;", "Z", "C", "B", "S", "I", "F", "J", "D", "[I")

    /**
     * 随机一个字符串,已做关键字排除处理
     * @param num Int
     * @return String
     */
    fun randomName(num: Int = 8): String {
        var clzz: String
        do {
            clzz = romdomClzz(num)
        } while (SourceVersion.isKeyword(clzz))
        return clzz
    }

    private fun romdomClzz(num: Int = 8): String {
        val clzz = StringBuilder()
        for (i in 0 until num) {
            val rlt = Random.nextInt(97, 123)
            clzz.append(rlt.toChar())
        }
        return clzz.toString()

    }

    fun getOpcode(): Int {
        val flag = ACC_LIST[Random.nextInt(ACC_LIST.size)]
        val acc = ACC_LIST1[Random.nextInt(ACC_LIST1.size)]
        return flag + acc;
    }

    fun getDescriptor(): String {
        return DESC_LIST[Random.nextInt(DESC_LIST.size)]
    }
}