package com.mckj.annotation.kt

import java.io.File
import java.util.jar.JarFile

fun File.getJarPath(): String {
    val path = this.absolutePath
    val transformPath = path.replace("\\", "/")
    val endSeparate = transformPath.lastIndexOf("/")
    return transformPath.substring(endSeparate + 1, path.length)
}

fun JarFile.getJarPath(): String {
    val path = this.name
    val transformPath = path.replace("\\", "/")
    val endSeparate = transformPath.lastIndexOf("/")
    return transformPath.substring(endSeparate + 1, path.length)
}

fun String.isClassFile(): Boolean {
    return (this.endsWith(".class")
            && !this.startsWith("R\$")
            && "R.class" != this
            && "BuildConfig.class" != this
            && "BR.class" != this)
}