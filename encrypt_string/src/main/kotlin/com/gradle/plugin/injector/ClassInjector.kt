package com.gradle.plugin.injector

import com.android.builder.utils.zipEntry
import com.dn.encrypt.ByteEncryptWrapper
import com.gradle.plugin.log.GLog
import com.gradle.plugin.vistor.ClassVisitorFactory
import jdk.internal.org.objectweb.asm.ClassReader
import jdk.internal.org.objectweb.asm.ClassWriter
import java.io.*
import java.util.jar.JarFile
import java.util.jar.JarInputStream
import java.util.jar.JarOutputStream

/**
 * ClassInjector
 *
 * @author mmxm
 * @date 2022/1/24 10:17
 */
class ClassInjector(implCls: String) {

    var byteEncryptWrapper: ByteEncryptWrapper = ByteEncryptWrapper(implCls)

    /**
     * 解析class
     * @param input InputStream
     * @param output OutputStream
     */
    fun doJumpClass(input: File, output: File) {
        var bis: BufferedInputStream? = null
        var bos: BufferedOutputStream? = null
        try {
            bis = BufferedInputStream(input.inputStream())
            bos = BufferedOutputStream(output.outputStream())
            processClass(bis, bos)
        } finally {
            bis?.close()
            bos?.close()
        }
    }

    /**
     * 解析jar
     * @param input InputStream
     * @param output OutputStream
     */
    fun doJumpJar(input: File, output: File) {
        output.writeBytes(input.readBytes())
//        val jarFile=JarFile(input)
//        val enum =jarFile.entries()
//        val jaros=JarOutputStream(FileOutputStream(output))
//        val jaris=JarInputStream(FileInputStream(input))
//
//        while (enum.hasMoreElements()){
//            val jarEntry=enum.nextElement()
//            val entityName=jarEntry.name
//            val zipEntry= zipEntry(entityName)
//            val inputIs=jarFile.getInputStream(zipEntry)
//            jaros.putNextEntry(zipEntry)
//            GLog.d("处理jar-class--->$entityName")
//            if(!entityName.endsWith("module-info.class")&&entityName.endsWith(".class")){
//                processClass(inputIs, jaros)
//            }else{
//                jaros.write(inputIs.readBytes())
//            }
//            jaros.closeEntry()
//        }
//        jaros.close()
//        jarFile.close()
    }

    private fun processClass(input: InputStream, output: OutputStream) {
        val cr = ClassReader(input)  //用来解析编译过的class字节码文件。
        val cw = ClassWriter(0)   //用来重新构建编译后的类，比如说修改类名、属性以及方法，甚至可以生成新的类的字节码文件
        val clsName = cr.className
        println("ClassInjector--->$clsName")
        val cv = ClassVisitorFactory.create(impl = byteEncryptWrapper, clsName, cw)
        cr.accept(cv, 0)  //接受新的改动
        output.write(cw.toByteArray()) //并写入源文件  ,这里读取的顺序别错了
        output.flush()

    }

    private fun processJar() {

    }

    @Throws(IOException::class)
    private fun copy(input: InputStream, out: OutputStream) {
        val buffer = ByteArray(8192)
        var c: Int
        while (input.read(buffer).also { c = it } != -1) {
            out.write(buffer, 0, c)
        }
    }
}