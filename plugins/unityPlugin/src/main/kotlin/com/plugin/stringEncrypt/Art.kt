package com.plugin.stringEncrypt

import com.android.build.gradle.AppExtension
import com.plugin.stringEncrypt.extension.UnitybugExtension
import com.plugin.stringEncrypt.transform.UnitybugTransform
import org.gradle.api.Plugin
import org.gradle.api.Project


/**
 * 注解移除
 *
 * @author mmxm
 * @date 2022/1/21 15:11
 */
class Art : Plugin<Project> {
    override fun apply(project: Project) {
        regiest(project)
    }

    fun regiest(project: Project) {
        project.extensions.create("unitybugExt", UnitybugExtension::class.java)

        if (project.plugins.hasPlugin("com.android.application")) {
            val appExtension = project.extensions.findByType(AppExtension::class.java)
            appExtension?.registerTransform(UnitybugTransform(project))
        }
    }
}