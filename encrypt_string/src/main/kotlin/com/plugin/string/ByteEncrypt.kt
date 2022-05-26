package com.plugin.string

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
import com.plugin.string.transform.AppEncryptTransform
import com.plugin.string.transform.LibEncryptTransform
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * StringEncrypt
 *
 * @author mmxm
 * @date 2022/1/21 15:11
 */
class ByteEncrypt : Plugin<Project> {


    override fun apply(project: Project) {
        project.dependencies.add("implementation","com.dn.encrypt:byteInterface:1.2.1")

        val byteEncryptExtension =
            project.extensions.create("byteEncrypt", ByteEncryptExtension::class.java)

        val testedExtension = project.extensions.findByType(TestedExtension::class.java)
        when (testedExtension) {
            is AppExtension -> {
                testedExtension.applicationVariants
                testedExtension.registerTransform(AppEncryptTransform(project))
                println("registerTransform---->AppEncryptTransform")

            }
            is LibraryExtension -> {
                testedExtension.libraryVariants
                testedExtension.registerTransform(LibEncryptTransform(project))
                println("registerTransform---->LibEncryptTransform")


            }
            else -> {
                println("TestedExtension is null")

            }
        }
    }


}