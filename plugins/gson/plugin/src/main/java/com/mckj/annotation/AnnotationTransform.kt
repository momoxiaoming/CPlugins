package com.mckj.annotation

import com.android.build.api.transform.*
import com.android.build.gradle.internal.pipeline.TransformManager
import com.android.utils.FileUtils
import com.mckj.annotation.utlis.GsonModifyUtils
import com.mckj.plugin.common.base.BaseTransform
import com.mckj.plugin.common.utils.Logger
import org.apache.commons.codec.digest.DigestUtils
import org.gradle.api.Project
import java.io.File

class AnnotationTransform(project: Project) : BaseTransform(project) {
    override fun getName(): String {
        return "annotation-transform-plugin"
    }

    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> {
        return TransformManager.CONTENT_CLASS
    }

    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    override fun isIncremental(): Boolean {
        return false
    }

    override fun transformDirFile(inputFile: File, file: File) {
        GsonModifyUtils.modifyDirectory(inputFile, file)
    }

    override fun transformJarFile(oriFile: File, destFile: File) {
        GsonModifyUtils.modifyJar(oriFile, destFile)
    }

    override fun initTransformConfig() {
        val extension = getExtension(Constant.ANNOTATION_CONFIG_NAME)
        extension?.let {
            extension as AnnotationExtension
            GsonModifyUtils.init(extension)
        }
    }
}