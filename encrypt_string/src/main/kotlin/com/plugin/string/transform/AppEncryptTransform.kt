package com.plugin.string.transform

import org.gradle.api.Project

/**
 * LibEncryptTransform
 *
 * @author mmxm
 * @date 2022/1/25 16:31
 */
class AppEncryptTransform(project: Project) : EncryptTransform(project) {
//    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
//      return  mutableSetOf(QualifiedContent.Scope.PROJECT,QualifiedContent.Scope.EXTERNAL_LIBRARIES,QualifiedContent.Scope.SUB_PROJECTS)
//    }
}