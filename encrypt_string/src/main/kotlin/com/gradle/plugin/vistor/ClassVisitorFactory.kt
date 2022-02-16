package com.gradle.plugin.vistor

import com.dn.encrypt.ByteEncryptWrapper
import com.dn.encrypt.IByteEncrypt
import com.gradle.plugin.encrypt.EncryptInjector
import com.gradle.plugin.log.GLog
import com.gradle.plugin.whiteLists.WhiteLists
import jdk.internal.org.objectweb.asm.ClassVisitor
import jdk.internal.org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes

/**
 * ClassVisitorFactory 工厂类
 * 主要是 生成ClassVisitor, 在这里,我们可以在此过滤类的白名单,比如过滤掉包名下的类
 * @author mmxm
 * @date 2022/1/22 18:29
 */
object ClassVisitorFactory {

    fun create(impl: IByteEncrypt, className:String, cw:ClassWriter): ClassVisitor {
        //如果在白名单内,可以创建一个默认的[ClassVisitor]
//        if(WhiteLists.isWhiteList(className)){
//            println("WhiteLists-->$className")
//            return emptyVisitor(cw)
//        }
        return if(EncryptInjector.getEncryptPackages()!=null){
            //只加密指定的包名下
            val rlt=EncryptInjector.getEncryptPackages()!!.find {
                parseClassName(className).startsWith(it)
            }
            GLog.d("指定包名--->$rlt")
            if(rlt!=null){
                ByteClassVisitor(cw,impl)
            }else{
                //不在此包名中,不加密
                emptyVisitor(cw)
            }
        }else{
            //未指定包名,默认全部加密
            ByteClassVisitor(cw,impl)
        }

    }

    private fun shortClassName(className:String):String{
       val arr= className.split("/")
       return arr.last()
    }
    private fun parseClassName(className:String):String{
        return className.replace("/",".")
    }
    private fun emptyVisitor(cw:ClassWriter):ClassVisitor{
        return object : ClassVisitor(Opcodes.ASM5,cw) {

        }
    }
}