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
     * 主要用于排重,防止生成的名称一样
     */
    private val map= hashMapOf<String,Int>()

    fun randomLengthName(form:Int=5,until:Int=20):String{
        return randomName(Random.nextInt(form,until))
    }

    /**
     * 随机一个字符串,已做关键字排除处理
     * @param num Int
     * @return String
     */
    fun randomName(num: Int = Random.nextInt(5,10)): String {
        var clzz: String
        do {
            clzz = romdomClzz(num)
        } while (SourceVersion.isKeyword(clzz))
        return if(map[clzz]==null){
            clzz
        }else{
            randomName(num)
        }
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

    /**
     * 随机生成颜色值
     * @return String
     */
    fun randomColor(): String {
        // 生成三个随机的RGB值
        val red = Random.nextInt(256)
        val green = Random.nextInt(256)
        val blue = Random.nextInt(256)
        // 将RGB值转换为十六进制表示
        return String.format("#%02x%02x%02x", red, green, blue)
    }
}