package com.plugin.art.helpr.scan

import com.android.build.api.transform.Format
import com.android.build.api.transform.TransformInput
import com.android.build.api.transform.TransformOutputProvider
import com.plugin.art.helpr.replace.JarReplaceHelper
import com.plugin.art.utils.ScanUtil
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
object JarScanHelper {

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
            val inputJar = JarFile(src)
            val outputJar = JarOutputStream(FileOutputStream(outputFile))
            val enumeration = inputJar.entries()
            while (enumeration.hasMoreElements()) {
                val entry = enumeration.nextElement()
                val inputStream = inputJar.getInputStream(entry)
                val outputEntry = ZipEntry(entry.name)
                outputEntry.time = entry.time
                outputJar.putNextEntry(outputEntry)

                if (ScanUtil.filterScanTaskClass(entry.name)) {
                    val codes=ScanUtil.scanClass2(inputStream)
                    if (codes != null) {
                        outputJar.write(codes)
                    }
                }else {
                    if(ScanUtil.filterClass(entry.name)){
                        //记录路由表类所在的jar路径
                        JarReplaceHelper.routerJarFile=src
                    }
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