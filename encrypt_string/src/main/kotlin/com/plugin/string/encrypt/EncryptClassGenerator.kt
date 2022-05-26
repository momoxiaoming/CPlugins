package com.plugin.string.encrypt

import com.dn.encrypt.IByteEncrypt
import com.squareup.javawriter.JavaWriter
import java.io.File
import java.io.FileWriter
import java.util.*
import javax.lang.model.element.Modifier


/**
 * 字节码层面生成一个默认的加密文件,并带入项目
 * 如果传入的自定义加密类为空,那么就是使用默认加解密,如果传入的自定义加密类不为空,那么优先使用自定义加解密类
 * @author mmxm
 * @date 2022/1/25 18:11
 */
object EncryptClassGenerator {
    /**
     * 生成默认加解密文件
     * @param targetClass String
     * @param applicationId String
     * @param outFile File
     */
    fun createDefaultEncrypt(targetClass:String,encryptImplCls:String,applicationId:String,outFile:File,pwd:ByteArray){
        //确定好是否是外部传入的自定义
        var key= ""
        pwd.forEach {
            key+="$it,"
        }
        key=key.substring(0,key.length-1)
        val implCls=encryptImplCls.split(".").last()
        val javaWriter =  JavaWriter( FileWriter(outFile));
        javaWriter.emitPackage(applicationId)
            .emitImports(IByteEncrypt::class.java)
            .emitImports(encryptImplCls)
            //创建类名
            .emitJavadoc("default encrypt class")
            .beginType(targetClass,"class", EnumSet.of(Modifier.PUBLIC, Modifier.FINAL),null)
            .emitField(IByteEncrypt::class.java.simpleName,"IMPL",EnumSet.of(Modifier.PRIVATE, Modifier.FINAL,Modifier.STATIC),"new $implCls()")
            .emitField(ByteArray::class.java.simpleName,"pwd",EnumSet.of(Modifier.PRIVATE, Modifier.FINAL,Modifier.STATIC),"new byte[]{$key}")
            .emitEmptyLine()
                //加密方法
            .beginMethod("byte[]","encrypt",EnumSet.of(Modifier.PUBLIC, Modifier.STATIC),String::class.java.simpleName,"content")
            .emitStatement("return IMPL.encrypt(pwd,content)")
            .endMethod()
            .emitEmptyLine()
            //解密方法
            .beginMethod("String","decrypt",EnumSet.of(Modifier.PUBLIC, Modifier.STATIC),"byte[]","content")
            .emitStatement("return IMPL.decrypt(pwd,content)")
            .endMethod()
            .emitEmptyLine()
            .endType()

        javaWriter.close()
    }

    /**
     * 生成转换文件
     */
    fun createEncryptWrapper(targetClass:String,applicationId:String,outFile:File){
        val javaWriter =  JavaWriter( FileWriter(outFile));
        javaWriter.emitPackage(applicationId)
            //创建类名
            .emitJavadoc("default encrypt class")
            .beginType(targetClass,"class", EnumSet.of(Modifier.PUBLIC, Modifier.FINAL))
            .endType()
        javaWriter.close()
    }
}