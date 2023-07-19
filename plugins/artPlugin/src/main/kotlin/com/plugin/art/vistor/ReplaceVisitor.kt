package com.plugin.art.vistor


import com.plugin.art.string.ReplaceStringManager
import org.objectweb.asm.MethodVisitor

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