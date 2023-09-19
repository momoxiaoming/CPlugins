package com.plugin.art.helpr.replace

import com.android.build.api.transform.Format
import com.android.build.api.transform.TransformInput
import com.android.build.api.transform.TransformOutputProvider
import com.plugin.art.log.GLog
import com.plugin.art.utils.ScanUtil
import org.gradle.internal.impldep.org.apache.commons.codec.digest.DigestUtils
import java.io.File
import java.io.FileOutputStream
import java.util.jar.JarFile
import java.util.jar.JarOutputStream
import java.util.zip.ZipEntry


/**
 * JarScanHelper
 *
 * @author mmxm
 * @date 2022/5/26 17:53
 */
object JarReplaceHelper {
    var routerJarFile:File?=null

    fun scanJar(transformInput: TransformInput, outputProvider: TransformOutputProvider) {
        // scan all jars
        transformInput.jarInputs.forEach { jarInput ->
            val outputFile = outputProvider.getContentLocation(
                jarInput.name,
                jarInput.contentTypes,
                jarInput.scopes,
                Format.JAR
            )
            val src=jarInput.file
            if(routerJarFile==null || routerJarFile?.path == src.path){
                val inputJar = JarFile(src)
                val outputJar = JarOutputStream(FileOutputStream(outputFile))
                val enumeration = inputJar.entries()
                while (enumeration.hasMoreElements()) {
                    val entry = enumeration.nextElement()
                    val inputStream = inputJar.getInputStream(entry)
                    val outputEntry = ZipEntry(entry.name)
                    outputEntry.time = entry.time
                    outputJar.putNextEntry(outputEntry)
                    if (ScanUtil.filterClass(entry.name)) {
                        GLog.i("JarReplaceHelper-->$entry.name")
                        val codes=ScanUtil.scanClass(inputStream)
                        if (codes != null) {
                            outputJar.write(codes)
                        }
                    } else {
                        outputJar.write(inputStream.readAllBytes())
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
}