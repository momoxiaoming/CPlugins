package com.plugin.art.helpr.scan

import com.android.build.api.transform.Format
import com.android.build.api.transform.TransformInput
import com.android.build.api.transform.TransformOutputProvider
import com.android.utils.FileUtils
import com.plugin.art.helpr.replace.JarReplaceHelper
import com.plugin.art.log.GLog
import com.plugin.art.utils.ScanUtil
import org.apache.commons.codec.digest.DigestUtils
import java.io.File
import java.io.FileOutputStream
import java.util.jar.JarFile
import java.util.jar.JarOutputStream
import java.util.zip.ZipEntry
import org.apache.commons.io.IOUtils
import java.io.InputStream
import java.io.OutputStream
import java.util.jar.JarEntry

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
            var destName = jarInput.name
            // rename jar files
            val hexName = DigestUtils.md5Hex(jarInput.file.absolutePath)
            if (destName.endsWith(".jar")) {
                destName = destName.substring(0, destName.length - 4)
            }
            // input file
            val src = jarInput.file
            // output file
            val dest = outputProvider.getContentLocation(
                destName + "_" + hexName,
                jarInput.contentTypes,
                jarInput.scopes,
                Format.JAR
            )
            GLog.i("jar-->src:${src.path}")
            handleJarFile(src)
            FileUtils.copyFile(src, dest)
        }
    }

    private fun handleJarFile(src: File) {
        val jarFile = JarFile(src)
        val tempFile = File(src.parent + File.separator + "${src.name}.jar")
        if (tempFile.exists()) {
            tempFile.delete()
        }
        val jarOutputStream = JarOutputStream(FileOutputStream(tempFile))
        val enumeration = jarFile.entries()
        while (enumeration.hasMoreElements()) {
            val jarEntry = enumeration.nextElement()
            val entryName = jarEntry.name
            val zipEntry = ZipEntry(entryName)
            val inputStream = jarFile.getInputStream(zipEntry)
            jarOutputStream.putNextEntry(zipEntry)
            if (ScanUtil.filterScanTaskClass(entryName)) {
                val codes=ScanUtil.scanClass2(inputStream)
                if (codes != null) {
                    jarOutputStream.write(codes)
                }
            }else {
                 if(ScanUtil.filterClass(entryName)){
                    //记录路由表类所在的jar路径
                    JarReplaceHelper.routerJarFile=src
                }
                jarOutputStream.write(IOUtils.toByteArray(inputStream))
            }
        }
        jarFile.close()
        jarOutputStream.close()
        if (src.exists()) {
            src.delete()
        }
        tempFile.renameTo(src)
    }
}