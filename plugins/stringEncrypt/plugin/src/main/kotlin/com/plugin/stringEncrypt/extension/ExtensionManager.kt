package com.plugin.stringEncrypt.extension

import org.gradle.api.Project

/**
 * ExtensionUtils
 *
 * @author mmxm
 * @date 2022/8/3 12:17
 */
object ExtensionManager {
    const val EXTENSION_TAG="stringEncryptExtension"

    lateinit var extension: StringEncryptExtension
    fun initExtension(project: Project) {
        extension = project.extensions.getByName(EXTENSION_TAG) as StringEncryptExtension
    }
}