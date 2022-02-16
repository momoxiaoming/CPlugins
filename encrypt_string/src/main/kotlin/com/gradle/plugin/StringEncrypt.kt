package com.gradle.plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
import com.gradle.plugin.encrypt.EncryptInjector
import com.gradle.plugin.transform.AppEncryptTransform
import com.gradle.plugin.transform.LibEncryptTransform
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * StringEncrypt
 *
 * @author mmxm
 * @date 2022/1/21 15:11
 */
class StringEncrypt : Plugin<Project> {


    override fun apply(project: Project) {
        project.dependencies.add("implementation","com.dn.encrypt:byteInterface:1.1.5-bate1")

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