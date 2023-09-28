package com.plugin.manifest_edit

import com.plugin.manifest_edit.extension.ManifestReplaceExtension
import com.plugin.manifest_edit.extension.ExtensionManager
import com.plugin.manifest_edit.log.GLog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

class MR : Plugin<Project> {
    override fun apply(project: Project) {
        regiest(project)
        hookAssetsTask(project)
    }

    private fun regiest(project: Project) {
        ExtensionManager.create(project)
    }

    private fun hookAssetsTask(project: Project) {
        println("assets obs 任务开始")
        project.afterEvaluate {
            ExtensionManager.initExtension(it)
            it.tasks.forEach { task ->
                if (task.name.matches(Regex("processReleaseManifest"))) {
                    task.doLast { assetTask ->
                        assetTask.outputs.files.forEach { file ->
                            println("outputs-->" + file.path)
                            file?.listFiles()?.forEach { item ->
                                if (item.path.endsWith("AndroidManifest.xml")) {
                                    replace(item)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun replace(file: File) {
//        val node = ExtensionManager.extension?.replaceNode
//        if (node == null || node.size == 0) return
        //解析manifest文件, 并添加节点
        val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file)
        val applicationElement =
            doc.documentElement.getElementsByTagName("application").item(0) as Element

        val nodes = applicationElement.childNodes.nodeToList()
        //拿到所有的节点
        val allNodes = getManifestAllNodeList(nodes, mutableListOf())
        replaceExcludeFromRecents(allNodes)
        //找出每个节点中需要替换的属性
        replaceNodeAttr(allNodes)
        //找出每个节点中需要增加的属性
        addNodeAttr(allNodes)
        //找出每个节点中需要删除的属性
        delNodeAttr(allNodes)

        //保存修改后的文件
        TransformerFactory.newInstance().newTransformer()
            .transform(DOMSource(doc), StreamResult(file))
    }


    /**
     * 替换属性节点
     * @param list List<Node>
     */
    fun replaceExcludeFromRecents(list: List<Node>) {
        val replaceAttr = ExtensionManager.extension?.replaceAttributes
        if (replaceAttr.isNullOrEmpty()) {
            return
        }
        val keyNodes = replaceAttr.keys
        list.forEach {
            val nodeName = it.nodeName
            if (keyNodes.contains(nodeName)) {
                val valueAttr = replaceAttr[nodeName]
                valueAttr?.forEach { attrMap ->
                    val key=attrMap.keys.first()
                    val vau=attrMap.values.first()
                    val attr = it.attributes.getNamedItem(key)
                    if (attr != null) {
                        GLog.i("replace: $key-->" + vau)
                        attr.nodeValue = vau
                    }
                }
            }
        }
    }

    private fun replaceNodeAttr(list: List<Node>) {
//        list.forEach {
//            GLog.i("replaceNodeAttr->node-->"+it)
//            if(it.nodeName=="activity"){
//                val attr = it.attributes.getNamedItem("android:excludeFromRecents")
//                GLog.i("replaceNodeAttr ->${attr}")
//                if (attr != null) {
//                    attr.nodeValue = "false"
//                }
//            }
//
//        }
    }

    private fun addNodeAttr(list: List<Node>) {

    }

    private fun delNodeAttr(list: List<Node>) {

    }

    /**
     * 获取manifest下所有节点
     */
    private fun getManifestAllNodeList(list: List<Node>, retList: MutableList<Node>): List<Node> {
        for (i in 0 until list.size) {
            val node = list[i]
            val nodeChildList = node.nodeToList()
            retList.add(node)
            if (nodeChildList.isNotEmpty()) {
                //有子节点, 递归
                getManifestAllNodeList(nodeChildList, retList)
            }

        }
        return retList
    }

    fun Node.nodeToList(): List<Node> {
        val list = mutableListOf<Node>()
        for (i in 0 until this.childNodes.length) {
            list.add(this.childNodes.item(i))
        }
        return list
    }

    fun NodeList.nodeToList(): List<Node> {
        val list = mutableListOf<Node>()
        for (i in 0 until length) {
            list.add(this.item(i))
        }
        return list
    }

}