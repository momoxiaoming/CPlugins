package com.mckj.junkCode

import com.android.build.gradle.AppExtension
import com.android.manifmerger.XmlElement
import com.android.manifmerger.XmlNode
import com.android.utils.forEach
import com.mckj.junkCode.ext.ExtensionManager
import com.mckj.junkCode.ext.JunkCodeExtension
import com.mckj.junkCode.util.Helper
import org.apache.xerces.parsers.XMLDocumentParser
import org.apache.xerces.parsers.XMLParser
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
 *
 * @author mmxm
 * @date 2023/7/7 18:18
 */
class JunkCodePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        regiestExt(project)
        hookTask(project)
    }

    fun regiestExt(project: Project) {
        project.extensions.create(ExtensionManager.extensionTagName, JunkCodeExtension::class.java)
    }

    private fun hookTask(project: Project) {
        project.afterEvaluate {
            ExtensionManager.initExtension(it)
            if (it.plugins.hasPlugin("com.android.application")) {
                project.tasks.forEach { task ->
                    if (task.name.matches(Regex("processReleaseManifest"))) {
                        println("taskName-->" + task.name)
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
                    }
                }
            }
        }
    }

    private fun randomManifest(file: File) {
        val num = ExtensionManager.getRomManifestNodeNum()
        if (num == 0) return
        //解析manifest文件, 并添加节点
        val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file)
        val applicationElement = doc.documentElement.getElementsByTagName("application").item(0) as Element
        //随机添加节点
        addRandomElement(num,doc, applicationElement)

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
    private fun randomAllElement(applicationElement:Element){
        val nodeList= mutableListOf<Element>()
        val nodes=applicationElement.childNodes
        //打乱顺序
        for(i in 0..nodes.length){
            val node=nodes.item(i)
            if(node is Element){
                nodeList.add(node)
            }
        }
        nodeList.shuffle()
        //找出activity-alias,放置数据末尾
        val aliasList= mutableListOf<Element>()
        nodeList.forEach {
            if (it.nodeName.contains("activity-alias")){
                aliasList.add(it)
            }
        }
        aliasList.forEach {
            nodeList.remove(it)
        }
        nodeList.addAll(aliasList)

        //移除原有的所有节点
        for(node in nodeList){
            applicationElement.removeChild(node)
        }

        //添加打乱后的节点
        for(node in nodeList){
            applicationElement.appendChild(node)
        }
    }

    private fun addRandomElement(num:Int,doc: Document, element: Element) {
        //随机添加
        createAndroidElement(doc, element, Random.nextInt(num), "activity")
        createAndroidElement(doc, element, Random.nextInt(num), "service")
        createAndroidElement(doc, element, Random.nextInt(num), "meta-data")
    }

    private fun createAndroidElement(doc: Document, element: Element, num: Int, nodeName: String) {
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
                        it.setAttribute("android:value", Helper.randomName(16))
                    }
                }

                else -> {
                    doc.createElement(nodeName).also {
                        it.setAttribute("android:name", clz)
                        it.setAttribute("android:exported", "false")
                    }
                }
            }
            element.appendChild(node)
        }
    }

}