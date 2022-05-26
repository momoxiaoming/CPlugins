package com.plugin.string.utils

import com.plugin.string.string.ReplaceStringManager
import com.plugin.string.vistor.ByteClassVisitor
import jdk.internal.org.objectweb.asm.ClassReader
import jdk.internal.org.objectweb.asm.ClassWriter
import java.io.InputStream

/**
 * ScanUtil
 *
 * @author mmxm
 * @date 2022/5/26 16:28
 */
object ScanUtil {

    fun scanClass(inputStream: InputStream) {
        val cr = ClassReader(inputStream)
        val cw = ClassWriter(cr, 0)
        val cv = ByteClassVisitor(cw, ReplaceStringManager)
        cr.accept(cv, ClassReader.EXPAND_FRAMES)
        inputStream.close()
    }
}