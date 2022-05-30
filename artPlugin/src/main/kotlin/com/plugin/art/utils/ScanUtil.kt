package com.plugin.art.utils


import com.plugin.art.vistor.ByteClassVisitor

import org.apache.commons.io.IOUtils
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
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

        }
        return null
    }
}