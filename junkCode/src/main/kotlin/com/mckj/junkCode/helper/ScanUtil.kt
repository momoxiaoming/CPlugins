package com.mckj.junkCode.helper


import com.mckj.junkCode.ext.ExtensionManager
import com.mckj.junkCode.transform.JunkCodeClassVisitor
import org.apache.commons.io.IOUtils
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.tree.ClassNode
import java.io.InputStream

/**
 * ScanUtil
 *
 * @author mmxm
 * @date 2022/5/26 16:28
 */
object ScanUtil {

    fun filterClass(path: String): Boolean {
        return ExtensionManager.extension?.junkPackages?.map { it.replace(".", "/") }
            ?.find { path.startsWith(it) } != null
    }

    /**
     * 替换路由以及删除注解
     */
    fun scanClass(inputStream: InputStream): ByteArray? {
        try {
            val classReader = ClassReader(IOUtils.toByteArray(inputStream))
            val classWriter = ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)
            val classNode = ClassNode()
            classReader.accept(classNode, ClassReader.EXPAND_FRAMES)
            val classVisitor = JunkCodeClassVisitor(classWriter, classNode.methods)
            classReader.accept(classVisitor, ClassReader.EXPAND_FRAMES)
            return classWriter.toByteArray()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }


}