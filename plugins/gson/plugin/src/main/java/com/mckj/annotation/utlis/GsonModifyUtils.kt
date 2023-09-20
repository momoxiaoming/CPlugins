package com.mckj.annotation.utlis

import com.mckj.annotation.AnnotationExtension
import com.mckj.annotation.kt.getJarPath
import com.mckj.annotation.kt.isClassFile
import com.mckj.annotation.visitor.PluginClassVisitor
import com.mckj.plugin.common.utils.Logger
import org.apache.commons.io.IOUtils
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import java.io.*
import java.util.jar.JarFile
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

object GsonModifyUtils {

    private var extension: AnnotationExtension = AnnotationExtension()

    fun init(extension: AnnotationExtension) {
        this.extension = extension
    }

    /**
     * 修改目录下对应的Class
     * @param directoryFile 对应的目录文件
     * @param destFile 输出对应的文件
     */
    fun modifyDirectory(directoryFile: File, destFile: File) {
        runCatching {
            val className = destFile.name
            var root = directoryFile.absolutePath
            if (!root.endsWith(File.separator)) {
                root += File.separator
            } //转换对应的classPath地址
            var classPath = destFile.absolutePath.replace(root, "")
            classPath = classPath.replace("\\", "/")
            if (!extension.isWhiteList(classPath) || !className.isClassFile()) {
                return
            }
            Logger.i("modifyDirectory oriDirectory[$classPath],className[$className]")
            val newBytes = modifyClass(classPath, destFile.readBytes())
            val fos = FileOutputStream(destFile.absolutePath)
            fos.write(newBytes)
            fos.close()
        }

    }


    /**
     * 修改jar对应class下的字节码
     * @param inputJar 源输入文件
     * @param outJar 输出文件
     */
    fun modifyJar(inputJar: File, outJar: File) {
        runCatching {
            val destFos = ZipOutputStream(FileOutputStream(outJar)) //设置输出文件
            val oriJarFile = JarFile(inputJar)
            val entries = oriJarFile.entries()
            while (entries.hasMoreElements()) { //遍历每个jar下的class
                val entry = entries.nextElement()
                val zis = oriJarFile.getInputStream(entry)
                val oriBytes = IOUtils.toByteArray(zis)
                val className = entry.name
                destFos.putNextEntry(ZipEntry(className))
                if (extension.isWhiteList(className) && className.isClassFile()) { //如果是白名单里面的class,修改字节码
                    Logger.i("modifyJar oriJarName[${oriJarFile.getJarPath()}],className[$className]")
                    val newBytes = modifyClass(className, oriBytes)
                    destFos.write(newBytes, 0, newBytes.size)
                } else {
                    destFos.write(oriBytes, 0, oriBytes.size)
                }
                zis.close()
            }
            destFos.flush()
            destFos.close()
        }
    }

    private fun modifyClass(classPath: String, bytes: ByteArray): ByteArray {
        val cr = ClassReader(bytes)
        val cw = ClassWriter(cr, ClassWriter.COMPUTE_MAXS)
        val visitor = PluginClassVisitor(cw, classPath)
        cr.accept(visitor, ClassReader.EXPAND_FRAMES)
        return try {
            cw.toByteArray()
        } catch (e: Exception) {
            Logger.i("scanClass writer failed: ${e.message}")
            bytes
        }
    }
}