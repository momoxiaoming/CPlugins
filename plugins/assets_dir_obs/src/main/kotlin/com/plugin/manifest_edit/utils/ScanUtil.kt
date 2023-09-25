package com.plugin.manifest_edit.utils


import com.plugin.manifest_edit.extension.ExtensionManager
import com.plugin.manifest_edit.vistor.ByteClassVisitor

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

    fun filterClass(path: String): Boolean {
        return ExtensionManager.getAssetStringClass().map { it.replace(".", "/") }
            .find { path.startsWith(it) } != null
    }

    /**
     * 替换路由以及删除注解
     */
    fun scanClass(inputStream: InputStream): ByteArray? {
        try {
            val classReader = ClassReader(IOUtils.toByteArray(inputStream))
            val classWriter = ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)
            val classVisitor = ByteClassVisitor(classWriter)
            classReader.accept(classVisitor, ClassReader.EXPAND_FRAMES)
            return classWriter.toByteArray()
        } catch (e: Exception) {
            e.printStackTrace()

        }
        return null
    }


}