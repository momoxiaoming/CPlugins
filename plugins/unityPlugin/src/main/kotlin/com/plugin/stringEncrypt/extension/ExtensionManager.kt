package com.plugin.stringEncrypt.extension

import org.gradle.api.Project

/**
 * ExtensionUtils
 *
 * @author mmxm
 * @date 2022/8/3 12:17
 */
object ExtensionManager {
    var extension: UnitybugExtension? = null
    fun initExtension(project: Project) {
        extension = project.extensions.getByName("unitybugExt") as UnitybugExtension
    }
}