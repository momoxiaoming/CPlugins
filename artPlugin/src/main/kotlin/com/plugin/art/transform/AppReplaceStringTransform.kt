package com.plugin.art.transform

import com.plugin.art.transform.ReplaceTransform
import org.gradle.api.Project

/**
 * AppReplaceStringTransform
 *
 * @author mmxm
 * @date 2022/1/25 16:31
 */
class AppReplaceStringTransform(project: Project) : ReplaceTransform(project) {
//    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
//      return  mutableSetOf(QualifiedContent.Scope.PROJECT,QualifiedContent.Scope.EXTERNAL_LIBRARIES,QualifiedContent.Scope.SUB_PROJECTS)
//    }
}