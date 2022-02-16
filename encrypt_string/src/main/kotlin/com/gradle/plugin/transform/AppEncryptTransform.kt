package com.gradle.plugin.transform

import com.android.build.api.transform.QualifiedContent
import org.gradle.api.Project
import org.gradle.internal.impldep.com.google.common.collect.ImmutableSet

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