package com.mckj.junkCode

import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.tasks.factory.dependsOn
import com.mckj.junkCode.ext.ExtensionManager
import com.mckj.junkCode.ext.JunkCodeExtension
import com.mckj.junkCode.task.JunkAssetsGenerateClassTask
import com.mckj.junkCode.task.JunkCodeGenerateClassTask
import com.mckj.junkCode.task.JunkResGenerateClassTask
import com.mckj.junkCode.transform.JunkCodeTransForm
import com.mckj.junkCode.util.Helper
import com.mckj.junkCode.util.logI
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.w3c.dom.Document
import org.w3c.dom.Element
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import kotlin.random.Random

/**
 * JunkCodePlugin
 * 1. 添加垃圾类,方法,变量
 * 2. manifest添加垃圾类
 * 3. manifest乱序
 * @author mmxm
 * @date 2023/7/7 18:18
 */
class JunkCodePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        regiestExt(project)
        hookTask(project)
    }

    private fun regiestExt(project: Project) {
        project.extensions.create(ExtensionManager.extensionTagName, JunkCodeExtension::class.java)
        if (project.plugins.hasPlugin("com.android.application")) {
            val appExtension = project.extensions.findByType(AppExtension::class.java)
            appExtension?.registerTransform(JunkCodeTransForm())
        }
    }

    private fun addRandomClassTask(project: Project) {
        val appExtension = project.extensions.getByType(AppExtension::class.java)
        appExtension.applicationVariants.all {
            //插入垃圾代码
            val junkCodeOut=File(project.buildDir, "generated/source/junkCode/${it.name}")
            val junkCodeTask=project.tasks.create("generate${it.name.capitalize()}JunkCode",JunkCodeGenerateClassTask::class.java)
            junkCodeTask.outDirPath=junkCodeOut.path
            it.registerJavaGeneratingTask(junkCodeTask,junkCodeOut)
            it.generateBuildConfigProvider.get().dependsOn(junkCodeTask)

            //插入资源
            val junkResOut=File(project.buildDir, "generated/res/junkCode/${it.name}")
            val junkResTask=project.tasks.create("generate${it.name.capitalize()}JunkResource",JunkResGenerateClassTask::class.java)
            junkResTask.resDirPath=junkResOut.path
            it.registerGeneratedResFolders(project.files(junkResOut).builtBy(junkResTask))
            it.mergeResourcesProvider.dependsOn(junkResTask)
        }
    }


    private fun hookTask(project: Project) {
        project.afterEvaluate {
            ExtensionManager.initExtension(it)
            if (it.plugins.hasPlugin("com.android.application")) {
                addRandomClassTask(it)
                project.tasks.forEach { task ->
                    if (task.name.matches(Regex("^process\\S*Manifest\$"))) {
                        task.doLast { assetTask ->
                            assetTask.outputs.files.forEach { file ->
                                println("outputs-->" + file.path)
                                file?.listFiles()?.forEach { item ->
                                    if (item.path.endsWith("AndroidManifest.xml")) {
                                        randomManifest(item)
                                    }
                                }
                            }
                        }
                    } else if (task.name.matches(Regex("^merge\\S*GeneratedProguardFiles\$"))) {
                        task.doLast { assetTask ->
                            assetTask.outputs.files.forEach { file ->
                                println("outputs-->" + file.path)
                                if(file.path.endsWith("proguard.txt")){
                                    addProguard(file)
                                }
                            }
                        }
                    }else if (task.name.matches(Regex("^merge\\S*ReleaseAssets\$"))) {
                        task.doLast { assetTask ->
                            assetTask.outputs.files.forEach { file ->
                                if (file.path.contains("assets")) {

                                    logI("merged_assets-->${file.path}")

                                    JunkAssetsGenerateClassTask.doTask(file)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun addProguard(file: File) {
        if(!file.exists()){
            var lines=""
            ExtensionManager.mappingMap.forEach {
                lines+="\n $it"
            }
            file.writeText(lines)
        }else{
            var proguard=file.readText()
            ExtensionManager.mappingMap.forEach {
                proguard+="\n $it"
            }
            file.writeText(proguard)
        }
        ExtensionManager.proguardFile=file
    }

    private fun randomManifest(file: File) {
        val num = ExtensionManager.getRomManifestNodeNum()
        if (num == 0) return
        //解析manifest文件, 并添加节点
        val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file)
        val applicationElement =
            doc.documentElement.getElementsByTagName("application").item(0) as Element
        //随机添加节点
        addRandomElement(num, doc, applicationElement)

        //随机打乱节点
        randomAllElement(applicationElement)

        //保存修改后的文件
        TransformerFactory.newInstance().newTransformer()
            .transform(DOMSource(doc), StreamResult(file))
    }

    /**
     * 随机打乱所有application下节点
     * 注意这里要排除activity-alias 节点, 此种只能放于数组末尾,否者可能会出错
     */
    private fun randomAllElement(applicationElement: Element) {
        val nodeList = mutableListOf<Element>()
        val nodes = applicationElement.childNodes
        //打乱顺序
        for (i in 0..nodes.length) {
            val node = nodes.item(i)
            if (node is Element) {
                nodeList.add(node)
            }
        }
        nodeList.shuffle()
        //找出activity-alias,放置数据末尾
        val aliasList = mutableListOf<Element>()
        nodeList.forEach {
            if (it.nodeName.contains("activity-alias")) {
                aliasList.add(it)
            }
        }
        aliasList.forEach {
            nodeList.remove(it)
        }
        nodeList.addAll(aliasList)

        //移除原有的所有节点
        for (node in nodeList) {
            applicationElement.removeChild(node)
        }

        //添加打乱后的节点
        for (node in nodeList) {
            applicationElement.appendChild(node)
        }
    }

    private fun addRandomElement(num: Int, doc: Document, element: Element) {
        //随机添加
        createAndroidElement(doc, element, Random.nextInt(num), "activity")
        createAndroidElement(doc, element, Random.nextInt(num), "service")
        createAndroidElement(doc, element, Random.nextInt(num), "meta-data")
    }

    private fun createAndroidElement(doc: Document, element: Element, num: Int, nodeName: String) {
        logI("随机$num 个 $nodeName")
        for (i in 0..num) {
            val clz = "${Helper.randomName(Random.nextInt(4, 8))}.${
                Helper.randomName(
                    Random.nextInt(
                        4,
                        8
                    )
                )
            }.${Helper.randomName(Random.nextInt(4, 8))}"
            val node = when (nodeName) {
                "meta-data" -> {
                    doc.createElement(nodeName).also {
                        it.setAttribute("android:name", clz)
                        it.setAttribute("android:value", Helper.randomLengthName(10,30))
                    }
                }

                else -> {
                    doc.createElement(nodeName).also {
                        it.setAttribute("android:name", clz)
                        it.setAttribute("android:exported", "false")
                    }
                }
            }
//            println(
//                "junkCode-->add name --> name:${node.nodeName}, android:name: ${
//                    node.getAttribute(
//                        "android:name"
//                    )
//                }"
//            )
            element.appendChild(node)
        }
    }

}