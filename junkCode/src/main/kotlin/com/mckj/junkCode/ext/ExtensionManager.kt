package com.mckj.junkCode.ext

import org.gradle.api.Project

/**
 * JunkCodeExtension
 *
 * @author mmxm
 * @date 2023/7/7 18:23
 */
object ExtensionManager {

    val extensionTagName = "junkCodeExtension"

    private var extension: JunkCodeExtension? = null

    fun initExtension(project: Project) {
        extension = project.extensions.getByName(extensionTagName) as JunkCodeExtension
    }


    fun getRomManifestNodeNum():Int{
        return extension?.maxManifestJunkNodeNum?:0
    }

}