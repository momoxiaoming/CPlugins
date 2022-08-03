package com.plugin.art.utils


import com.plugin.art.transform.AScanTransform
import com.plugin.art.vistor.ARScanClassVisitor
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
                || path.contains("android/support/")
                || path.contains("org/intellij")
                || path.contains("kotlin/")
                || path.contains("META-INF")
                || path.contains("kotlin_module")
//                || path.startsWith("com/alibaba/android/arouter/core/LogisticsCenter")

    }

    fun filterScanTaskClass(path:String):Boolean{
        return path.startsWith(Common.ROUTER_PACKAGE)
    }
    /**
     * 替换路由以及删除注解
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

    /**
     * 扫描路由
     */
    fun scanClass2(inputStream: InputStream): ByteArray? {
        try {
            val classReader = ClassReader(IOUtils.toByteArray(inputStream))
            val classWriter = ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)
            val classVisitor = ARScanClassVisitor( classWriter)
            classReader.accept(classVisitor, ClassReader.EXPAND_FRAMES)
            return classWriter.toByteArray()
        } catch (e: Exception) {
            e.printStackTrace()

        }
        return null
    }


    fun addRoutesList(clzz:String?){
        if(clzz!=null&&clzz.startsWith(Common.ROUTER_PACKAGE)){
            AScanTransform.routes[clzz]=clzz
        }
    }
}