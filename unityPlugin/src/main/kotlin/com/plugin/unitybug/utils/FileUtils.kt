package com.plugin.unitybug.utils

import java.io.File

/**
 * FileUtils
 *
 * @author mmxm
 * @date 2022/1/21 15:51
 */



fun File.eachFileRecurse( fileBlock: (File) -> Unit) {
    if (isDirectory) {
        val files = listFiles() ?: return
        for (file in files) {
            if (file.isDirectory) {
                file.eachFileRecurse( fileBlock)
            } else {
                fileBlock(file)
            }
        }
    } else {
        fileBlock(this)
    }
}

fun File.getAllFile(): MutableList<File> {
    val outList = mutableListOf<File>()
    eachFileRecurse{
        outList.add(it)
    }
    return outList
}