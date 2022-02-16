package com.gradle.plugin.encrypt

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
import com.android.build.gradle.api.BaseVariant
import com.gradle.plugin.ByteEncryptExtension
import com.gradle.plugin.injector.ClassInjector
import com.gradle.plugin.log.GLog
import org.gradle.api.Project
import java.io.File
import java.util.*

/**
 * EncryptInjector
 *
 * @author mmxm
 * @date 2022/1/24 11:10
 */
object EncryptInjector {

    private val byteEncryptImpl = "ByteEncryptImpl"  //生成的默认解密类的名称

    private var mKey: String = ""
    private var encryptImplCls: String = "com.dn.encrypt.DefaultEncImpl"  //默认加密
    private var encryptPackages: Array<String>? = null
    private var applicationId: String = ""

    lateinit var injector: ClassInjector

    fun create(project: Project) {
        project.extensions.findByType(ByteEncryptExtension::class.java)?.let {
            GLog.setDebug(it.debug)
            if (!it.key.isNullOrEmpty()) {
                mKey = it.key!!
            }
            if (!it.encryptPackages.isNullOrEmpty()) {
                GLog.d("检测到包名加密-->${it.encryptPackages}")
                this.encryptPackages = it.encryptPackages
            }
            if (!it.encryptImplCls.isNullOrEmpty()) {
                //如果传入的自定义加密不为空不为空,我们需要将其写入字节码
                GLog.d("检测到自定义加密类-->${it.encryptImplCls}")
                this.encryptImplCls = it.encryptImplCls!!
            }
            createEncryptClass(project)

        }

    }

    /**
     * 获取插件动态生成的加密中间类
     * @return String
     */
    fun getRuntimeEncrypt(): String {
        return "${applicationId}.${byteEncryptImpl}"
    }

    fun getEncryptPackages():Array<String>?{
        return encryptPackages
    }

    /**
     * 创建解密的字节码文件
     */
    private fun createEncryptClass(project: Project) {
        project.extensions.findByType(TestedExtension::class.java).let {
            when (it) {
                is AppExtension -> {
                    applicationId = it.applicationVariants.first().applicationId
                    it.applicationVariants.all { variant ->
                        doVariant(project, variant)
                    }
                }
                is LibraryExtension -> {
                    applicationId = it.libraryVariants.first().applicationId
                    it.libraryVariants.all { variant ->
                        doVariant(project, variant)
                    }
                }
            }
        }
    }

    private fun doVariant(project: Project, variant: BaseVariant) {
        val variantName = variant.name.toUpperCase(Locale.getDefault())[0] + variant.name.substring(
            1,
            variant.name.length - 1
        )
        val genTask = project.tasks.create("generate${variantName}ByteEncrypt")
        val outFilePath = File(
            project.buildDir,
            "generated${File.separator}source${File.separator}byteEncrypt${File.separator}${variant.name}${File.separator}${
                applicationId.replace(
                    ".",
                    File.separator
                )
            }${File.separator}"
        )
        if (!outFilePath.exists()) {
            outFilePath.mkdirs()
        }
        //会在generated/source/byteEncrypt/applicationid/runtimeByteEncryptImpl默认解密类
        variant.registerJavaGeneratingTask(genTask, outFilePath)
        genTask.doLast {

            injector = ClassInjector(encryptImplCls)
            //首先我们会生成两个文件
            //1个时默认的加解密文件
            val outFile1 = File(outFilePath, "${byteEncryptImpl}.java")
            if (!outFile1.exists()) {
                outFile1.createNewFile()
            }
            EncryptClassGenerator.createDefaultEncrypt(
                byteEncryptImpl,
                encryptImplCls,
                applicationId,
                outFile1
            )
//            //2.加解密wrapper文件,用于转换自定义加密和默认加密的文件
//            val outFile2=File(outFilePath, "${runtimeByteEncryptWrapper}.java")
//            EncryptClassGenerator.createEncryptWrapper("${applicationId}.${runtimeByteEncryptWrapper}", applicationId,outFile2)
        }
    }
}