package com.plugin.string.vistor

import com.dn.encrypt.IByteEncrypt
import com.plugin.string.encrypt.EncryptInjector
import jdk.internal.org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * 主要处理asm的相关加密
 *
 * @author mmxm
 * @date 2022/2/14 10:36
 */
object EncryptVisitor {

    /**
     * 对字符串混淆并插入解密方法
     */
    fun stringProguardAndDecrypt(impl:IByteEncrypt,cst:String,mv:MethodVisitor){
        try {//加密
            if(cst.startsWith("com.alibaba.android.arouter.routes")){
                println("检测到router路径,寻求替换")
                mv.visitLdcInsn("com.alibaba.android.arouter.routes.xxxx")
                return
            }

            val byteArray = impl.encrypt(EncryptInjector.AES_KEY,cst)
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
            //直接将解密方法压入栈中当做常量使用
            mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                EncryptInjector.getRuntimeEncrypt().replace(".","/"),//注意这里的路径要是/,不能是. ,都在运行一直会有未知错误
                "decrypt",
                "([B)Ljava/lang/String;",
                false
            )

        } catch (e: Exception) {
            e.printStackTrace()
            println("byte encrypt error e=>$e")
        }
    }

}