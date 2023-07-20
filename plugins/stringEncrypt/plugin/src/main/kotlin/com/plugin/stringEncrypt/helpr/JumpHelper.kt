package com.plugin.stringEncrypt.helpr

import com.android.build.api.transform.Format
import com.android.build.api.transform.TransformInput
import com.android.build.api.transform.TransformOutputProvider
import com.plugin.stringEncrypt.extension.ExtensionManager
import com.plugin.stringEncrypt.utils.eachFileRecurse
import com.plugin.stringEncrypt.vistor.ByteClassVisitor
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.util.jar.JarFile
import java.util.jar.JarOutputStream
import java.util.zip.ZipEntry

/**
 * 解析class
 */
object JumpHelper {

    fun doJump(transformInput: TransformInput, outputProvider: TransformOutputProvider) {
        //scan all class
        transformInput.directoryInputs.forEach { directoryInput ->
            val dest = outputProvider.getContentLocation(
                directoryInput.name,
                directoryInput.contentTypes,
                directoryInput.scopes,
                Format.DIRECTORY
            )
            FileUtils.forceMkdir(dest)
            var root = directoryInput.file.absolutePath
            if (!root.endsWith(File.separator)) {
                root += File.separator
            }
            directoryInput.file.eachFileRecurse {
                var inputFilePath = it.path.replace(root, "")//将路径前缀移除,留下类包名路径
                if (File.separatorChar != '/') {
                    inputFilePath = inputFilePath.replace("\\\\", "/").replace("\\", "/")
                }
                if(filterClass(inputFilePath)){
                    val fis=FileInputStream(it)
                    val visitorData= visitorClass(fis)
                    if(visitorData!=null){
                        val fos = FileOutputStream(it)
                        fos.write(visitorData)
                        fos.close()
                    }
                    fis.close()
                }
            }
            FileUtils.copyDirectory(directoryInput.file, dest)
        }

        // scan all jars
        transformInput.jarInputs.forEach { jarInput ->
            val outputFile = outputProvider.getContentLocation(
                jarInput.name,
                jarInput.contentTypes,
                jarInput.scopes,
                Format.JAR
            )
            val inputJar = JarFile(jarInput.file)
            val outputJar = JarOutputStream(FileOutputStream(outputFile))
            val enumeration = inputJar.entries()
            while (enumeration.hasMoreElements()) {
                val entry = enumeration.nextElement()
                val inputStream = inputJar.getInputStream(entry)
                val outputEntry = ZipEntry(entry.name)
                outputEntry.time = entry.time
                outputJar.putNextEntry(outputEntry)
                if (filterClass(entry.name)) {
                    val visitor= visitorClass(inputStream)
                    if(visitor!=null){
                        outputJar.write(visitor)
                    }else{
                        outputJar.write(IOUtils.toByteArray(inputStream))
                    }
                } else {
                    outputJar.write(IOUtils.toByteArray(inputStream))
                }
                outputJar.closeEntry()
                inputStream.close()
            }
            // close the input and output jars
            outputJar.close()
            inputJar.close()
        }
    }


    /**
     * 注意, 这里path是这种路径 a/b/c.class
     * @param path String
     * @return Boolean
     */
    private fun filterClass(path: String): Boolean {
        return ExtensionManager.extension.encryptPackages?.find {
            path.startsWith(it)
        }!=null
    }



    /**
     * 将过滤下的class交给ClassVisitor处理
     */
    private fun visitorClass(inputStream: InputStream): ByteArray? {
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