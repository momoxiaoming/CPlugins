package com.plugin.string.encrypt

import com.squareup.javawriter.JavaWriter
import java.io.File
import java.io.FileWriter
import java.lang.StringBuilder
import java.util.*
import javax.lang.model.element.Modifier


/**
 * 字节码层面生成一个java文件,用于防止arouter被keep
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
    fun createDefaultEncrypt(targetClass:String,applicationId:String,arouterFiles:List<String>,outFile:File){
        //确定好是否是外部传入的自定义
        val atr=StringBuilder()
        arouterFiles.forEach {
            atr.append("$it.class,")
        }

        val javaWriter =  JavaWriter( FileWriter(outFile));
        javaWriter.emitPackage(applicationId)
            //创建类名
            .emitJavadoc("default encrypt class")
            .beginType(targetClass,"class", EnumSet.of(Modifier.PUBLIC, Modifier.FINAL),null)
            .emitEmptyLine()
                //加密方法
            .emitField("Class[]","clzz",EnumSet.of(Modifier.PRIVATE, Modifier.FINAL,Modifier.STATIC),"new Class[]{$atr}")
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