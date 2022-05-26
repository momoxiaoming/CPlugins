package com.plugin.string.injector

import com.plugin.string.encrypt.EncryptInjector
import com.plugin.string.string.ReplaceStringManager
import com.plugin.string.vistor.ByteClassVisitor
import jdk.internal.org.objectweb.asm.ClassReader
import jdk.internal.org.objectweb.asm.ClassWriter
import java.io.*
import java.util.jar.JarFile
import java.util.jar.JarInputStream
import java.util.jar.JarOutputStream
import java.util.zip.ZipEntry

/**
 * ClassInjector
 *
 * @author mmxm
 * @date 2022/1/24 10:17
 */
class ClassInjector() {



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
            bos.write(processClass(bis))
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
        try {
            val jarFile = JarFile(input)
            val enum = jarFile.entries()
            val jaros = JarOutputStream(FileOutputStream(output))
            val jaris = JarInputStream(FileInputStream(input))
            while (enum.hasMoreElements()) {
                val jarEntry = enum.nextElement()
                val entityName = jarEntry.name
                val zipEntry = ZipEntry(entityName)
                val inputIs = jarFile.getInputStream(zipEntry)
                jaros.putNextEntry(zipEntry)
                val splitName = entityName.replace("/", ".")
                if (splitName.endsWith(".class")) {
                    jaros.write(processClass(inputIs))
                } else {
                    jaros.write(inputIs.readBytes())
                }
                inputIs.close()
                jaros.closeEntry()
            }
            jaros.close()
            jarFile.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun processClass(input: InputStream) :ByteArray{
       return try {
            val cr = ClassReader(input)  //用来解析编译过的class字节码文件。
            val cw = ClassWriter(0)   //用来重新构建编译后的类，比如说修改类名、属性以及方法，甚至可以生成新的类的字节码文件
            val cv = ByteClassVisitor(cw, ReplaceStringManager)
            cr.accept(cv, 0)  //接受新的改动
            cw.toByteArray()
        } catch (e: Exception) {
            input.readBytes()
        }
    }

    private fun writePackage(name:String):Boolean{
       return EncryptInjector.filterPackage(name)
    }
}