package com.plugin.manifest_edit.extension

import org.gradle.api.Project

object ExtensionManager {

    var extension: ManifestReplaceExtension? = null
    const val EXT_KEY="manifest_edit"
    fun create(project: Project){
        project.extensions.create(EXT_KEY, ManifestReplaceExtension::class.java)

    }
    fun initExtension(project: Project) {
        extension = project.extensions.getByName(EXT_KEY) as ManifestReplaceExtension
    }
}