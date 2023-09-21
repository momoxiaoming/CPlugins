package com.bytedance.android.plugin.extensions

import org.gradle.api.Project

/**
 * ExtensionManager
 *
 * @author mmxm
 * @date 2023/9/19 14:11
 */
object ExtensionManager {

    lateinit var aabResGuard: AabResGuardExtension

    fun initExtension(project: Project) {
        aabResGuard= project.extensions.getByName("aabResGuard") as AabResGuardExtension
    }

}