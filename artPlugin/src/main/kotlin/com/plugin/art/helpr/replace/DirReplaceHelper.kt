package com.plugin.art.helpr.replace

import com.android.build.api.transform.Format
import com.android.build.api.transform.TransformInput
import com.android.build.api.transform.TransformOutputProvider
import com.plugin.art.log.GLog
import com.plugin.art.transform.AScanTransform
import com.plugin.art.utils.Common
import com.plugin.art.utils.ScanUtil
import com.plugin.art.utils.eachFileRecurse
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

/**
 * DirScanHelper
 *
 * @author mmxm
 * @date 2022/5/26 17:53
 */
object DirReplaceHelper {

    fun scanDir(transformInput: TransformInput, outputProvider: TransformOutputProvider) {
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
            handleDirFile(root, directoryInput.file)
            FileUtils.copyDirectory(directoryInput.file, dest)
        }
    }

    private fun handleDirFile(root: String, inputFile: File) {
        if (!inputFile.exists()) {
            return
        }
        inputFile.eachFileRecurse {
            var inputFilePath = it.path.replace(root, "")
            if (File.separatorChar != '/') {
                inputFilePath = inputFilePath.replace("\\\\", "/").replace("\\", "/")
            }

            //这里可以对一些class进行过滤
            if(!ScanUtil.filterClass(inputFilePath)){
                GLog.i("DirReplaceHelper--eachDirFile----item->${inputFilePath}")
                val fis=FileInputStream(it)
                val codes=ScanUtil.scanClass(fis)
                fis.close()
                if (codes != null) {
                    val fos = FileOutputStream(it)
                    fos.write(codes)
                    fos.close()
                }
            }
        }
    }


}