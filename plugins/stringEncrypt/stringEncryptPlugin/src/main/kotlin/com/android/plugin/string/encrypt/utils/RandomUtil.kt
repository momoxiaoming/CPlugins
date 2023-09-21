package com.android.plugin.string.encrypt.utils

import java.util.*


/**
 * @Author: hzh
 * @Date: 2022/10/13
 * @Desc: 生成一个随机的字符串
 */
object RandomUtil {

    /**
     *
     * @return
     */
    fun genRandomStr():String {
        val randomC =  Random()
        val count = randomC.nextInt(7) + 3
        val random =  Random()
        val str = "abcdefghijklmnopqrstuvwxyz0123456789"
        val sb =  StringBuilder()

        for (j:Int in 0 until count) {
            val number = random.nextInt(36)
            sb.append(str[number])
        }

        return sb.toString()
    }
}