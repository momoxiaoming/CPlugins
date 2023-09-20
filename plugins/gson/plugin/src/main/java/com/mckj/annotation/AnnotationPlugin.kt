package com.mckj.annotation

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.mckj.annotation.utlis.Logger
import org.gradle.api.Plugin
import org.gradle.api.Project

class AnnotationPlugin : Plugin<Project> {

    private  var TAG = "Annotation::Transform >>> "

    override fun apply(target: Project) {
        Logger.make(TAG)
        Logger.i("Project enable annotation-transform plugin")
        val isApp = target.plugins.hasPlugin(AppPlugin::class.java)
        val android = target.extensions.getByType(AppExtension::class.java)
        if (isApp) {
            target.dependencies.add("implementation", "com.dn.vi.plugin:annotation-tools:1.0.1")
        }

        target.extensions.create(Constant.ANNOTATION_CONFIG_NAME, AnnotationExtension::class.java)
        val transformImpl = AnnotationTransform(target)
        android.registerTransform(transformImpl)
    }
}