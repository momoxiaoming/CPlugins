package com.plugin.reann.extension

import org.gradle.api.Project

/**
 * ExtensionUtils
 *
 * @author mmxm
 * @date 2022/8/3 12:17
 */
object ExtensionManager {
    var extension: AnnRemoveExtension? = null
    fun initExtension(project: Project) {
        extension = project.extensions.getByName("remove_annotation") as AnnRemoveExtension
        println("remove_annotation info :"+extension?.getRemovePkg()+extension?.getAnnList())
    }
}