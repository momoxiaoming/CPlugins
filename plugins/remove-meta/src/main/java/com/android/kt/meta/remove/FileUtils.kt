package com.android.kt.meta.remove

import org.gradle.internal.impldep.org.bouncycastle.asn1.iana.IANAObjectIdentifiers.directory
import java.io.File
import java.io.IOException

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