package com.mckj.junkCode.util

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

    /**
     * 随机一个字符串,已做关键字排除处理
     * @param num Int
     * @return String
     */
    fun randomName(num: Int = 8): String {
        var clzz:String
        do {
            clzz=romdomClzz(num)
        }while (SourceVersion.isKeyword(clzz))
        return clzz
    }

    private fun romdomClzz(num: Int = 8):String{
        val clzz = StringBuilder()
        for (i in 0 until num) {
            val rlt = Random.nextInt(97, 123)
            clzz.append(rlt.toChar())
        }
        return clzz.toString()

    }
}