package com.mckj.annotation.base

import com.android.build.api.transform.Format
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.mckj.annotation.utlis.Logger
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.io.FileUtils
import org.gradle.api.Project
import org.gradle.api.UnknownDomainObjectException
import java.io.File

abstract class BaseTransform(private val project: Project) : Transform() {

    fun getExtension(name: String): Any? {
        val extension = try {
            project.extensions.getByName(name)
        } catch (e: UnknownDomainObjectException) {
            null
        }
        return extension
    }

    abstract fun transformDirFile(inputFile: File, file: File)

    abstract fun transformJarFile(oriFile: File, destFile: File)

    abstract fun initTransformConfig()

    override fun transform(transformInvocation: TransformInvocation?) {
        super.transform(transformInvocation)
        val outputProvider =
            transformInvocation?.outputProvider ?: return super.transform(transformInvocation)
        val inputs = transformInvocation.inputs
        val startTime = System.currentTimeMillis()

        val leftSlash = File.separator == "/"
        if (!isIncremental) {
            outputProvider.deleteAll()
        }
        initTransformConfig()
        inputs.forEach { input ->
            Logger.i("start scan directory.")
            input.directoryInputs.forEach { directoryInput ->
                val dest = outputProvider.getContentLocation(
                    directoryInput.name,
                    directoryInput.contentTypes,
                    directoryInput.scopes,
                    Format.DIRECTORY
                )
                directoryInput.file.walkTopDown().forEach walkTopDown@{ file ->
                    if (file.isFile) {
                        transformDirFile(directoryInput.file, file)
                    }
                }
                FileUtils.copyDirectoryToDirectory(directoryInput.file, dest)
            }
            Logger.i("start scan jar.")
            input.jarInputs.forEach { jarInput ->
                var destName = jarInput.name
                val hexName = DigestUtils.md5Hex(destName).substring(0, 8)
                if (destName.endsWith(".jar")) {
                    destName = destName.substring(0, destName.length - 4)
                }
                val dest = outputProvider.getContentLocation(
                    destName + "_" + hexName, jarInput.contentTypes, jarInput.scopes, Format.JAR
                )
                val src = jarInput.file

                transformJarFile(src, dest)
            }
        }
        Logger.i("Scan finish, current cost time " + (System.currentTimeMillis() - startTime) + "ms")
    }
}