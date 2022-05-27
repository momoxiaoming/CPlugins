package com.plugin.string.vistor


import com.plugin.string.string.IReplaceString
import com.plugin.string.string.ReplaceStringManager
import jdk.internal.org.objectweb.asm.MethodVisitor

/**
 * 主要处理asm的相关加密
 *
 * @author mmxm
 * @date 2022/2/14 10:36
 */
object ReplaceVisitor {

    /**
     * 对字符串混淆并插入解密方法
     */
    fun stringProguardAndReplace( cst: String, mv: MethodVisitor) {
        try {//替换
            val rlt = ReplaceStringManager.replace(cst)
            mv.visitLdcInsn(rlt)
        } catch (e: Exception) {
            e.printStackTrace()
            println("replace string error e=>$e")
        }
    }

}