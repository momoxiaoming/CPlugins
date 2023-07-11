package com.mckj.junkCode.helper

import com.android.build.api.transform.Format
import com.android.build.api.transform.TransformInput
import com.android.build.api.transform.TransformOutputProvider
import org.apache.commons.io.IOUtils
import java.util.jar.JarFile
import java.util.jar.JarOutputStream
import java.util.zip.ZipEntry
import java.io.FileOutputStream
/**
 * JarHelper
 *
 * @author mmxm
 * @date 2023/5/6 15:32
 */
object JarHelper {
    fun scanJar(transformInput: TransformInput, outputProvider: TransformOutputProvider) {
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
                if (ScanUtil.filterClass(entry.name)) {
                    println("junkCode 需要插入垃圾代码的类-->${entry.name}")
                    val bt= ScanUtil.scanClass(inputStream)
                    if(bt!=null){
                        outputJar.write(bt)
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
}