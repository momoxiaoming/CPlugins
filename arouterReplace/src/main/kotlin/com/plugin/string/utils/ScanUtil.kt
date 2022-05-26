package com.plugin.string.utils


import com.plugin.string.vistor.ByteClassVisitor
import jdk.internal.org.objectweb.asm.ClassReader
import jdk.internal.org.objectweb.asm.ClassWriter
import org.apache.commons.io.IOUtils
import java.io.InputStream

/**
 * ScanUtil
 *
 * @author mmxm
 * @date 2022/5/26 16:28
 */
object ScanUtil {

    fun filterClass(path:String):Boolean{
        return !path.endsWith(".class") //排除非class文件
                || path.contains("R$") //排除资源文件
                || path.contains("com/google/android")
                || path.contains("androidx/")
                || path.contains("kotlin/")
                || path.contains("META-INF")
                || path.contains("kotlin_module")
    }

    /**
     * 扫描类
     */
    fun scanClass(inputStream: InputStream): ByteArray? {
        try {
            val classReader = ClassReader(IOUtils.toByteArray(inputStream))
            val classWriter = ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)
            val classVisitor = ByteClassVisitor( classWriter)
            classReader.accept(classVisitor, ClassReader.EXPAND_FRAMES)
            return classWriter.toByteArray()
        } catch (e: Exception) {
            e.printStackTrace()
            println("${e.printStackTrace()}")
        }
        return null
    }
}