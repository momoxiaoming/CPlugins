package com.plugin.art.utils

import java.lang.StringBuilder
import javax.lang.model.SourceVersion
import kotlin.random.Random

/**
 * Common
 *
 * @author mmxm
 * @date 2022/5/24 16:09
 */
object Common {

    var keepPkg = "a/b/c"

    val aMappingStringList= mutableListOf<String>()
    val aReplaceStringList= mutableListOf<String>()

    init {
        keepPkg = "${randomClzzName(3)}/${randomClzzName(3)}/${randomClzzName(3)}"
    }



    /**
     * 混淆arouter模块名或者group名
     * 随机生成5位字符串
     * @param clsName String
     */
     fun randomClzzName(num: Int = 8): String {
        var clzz:String
        do {
            clzz=romdomClzz(num)
        }while (SourceVersion.isKeyword(clzz))
        return clzz
    }

    fun romdomClzz(num: Int = 8):String{
        val clzz = StringBuilder()
        for (i in 0 until num) {
            val rlt = Random.nextInt(97, 123)
            clzz.append(rlt.toChar())
        }
        return clzz.toString()

    }
}