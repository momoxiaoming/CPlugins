package com.plugin.string.transform

import com.android.build.api.transform.QualifiedContent
import com.android.build.gradle.internal.pipeline.TransformManager
import org.gradle.api.Project

/**
 * LibReplaceStringTransform
 *
 * @author mmxm
 * @date 2022/1/25 16:31
 */
class LibReplaceStringTransform(project: Project) :ReplaceTransform(project) {
    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
        return TransformManager.PROJECT_ONLY

    }
}