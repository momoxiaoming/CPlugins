package com.plugin.stringEncrypt

import com.android.build.gradle.AppExtension
import com.plugin.stringEncrypt.extension.ExtensionManager
import com.plugin.stringEncrypt.extension.StringEncryptExtension
import com.plugin.stringEncrypt.transform.StringEncryptTransform
import org.gradle.api.Plugin
import org.gradle.api.Project


/**
 *
 */
class EncryptPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        initExtAndTransform(project)
        initTask(project)
    }

    /**
     * 初始化Extension和StringEncryptTransform
     * @param project Project
     */
    private fun initExtAndTransform(project: Project) {
        project.extensions.create(ExtensionManager.EXTENSION_TAG, StringEncryptExtension::class.java)
        project.extensions.findByType(AppExtension::class.java)?.registerTransform(StringEncryptTransform())
    }

    private fun initTask(project:Project){
        project.afterEvaluate {
            ExtensionManager.initExtension(project)
        }
    }

}