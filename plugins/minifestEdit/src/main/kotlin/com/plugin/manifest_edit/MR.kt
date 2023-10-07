package com.plugin.manifest_edit

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
        val docElement=doc.documentElement
        val applicationElement =docElement.getElementsByTagName("application").item(0) as Element
        //找出每个节点中需要替换的属性
        replaceNodeAttr(docElement)
        //找出每个节点中需要增加的属性
        addNodeAttr(docElement)
        //找出每个节点中需要删除的属性
        delNodeAttr(docElement)
        //保存修改后的文件
        TransformerFactory.newInstance().newTransformer()
            .transform(DOMSource(doc), StreamResult(file))
    }


    /**
     * 替换属性节点
     * @param list List<Node>
     */
    fun replaceNodeAttr(docElement: Element) {
        val replaceAttr = ExtensionManager.extension?.replaceAttributes
        if (replaceAttr.isNullOrEmpty()) {
            return
        }
        val keyNodes = replaceAttr.keys
        keyNodes.forEach {
            //找到所有此名字的节点
            val nodeListFotTag=docElement.getElementsByTagName(it).nodeToList()
            nodeListFotTag.forEach { node->
                //遍历所有此名字的节点, 替换属性(已有此属性则不添加)
                val nodeName = node.nodeName
                val attrMap = replaceAttr[nodeName]
                val key=attrMap?.keys?.first()
                val vau=attrMap?.values?.first()
                val attr = node.attributes.getNamedItem(key)
                if (attr != null) {
                    GLog.i("replace:node:$node key: $key-->" + vau)
                    attr.nodeValue = vau
                }
            }
        }
    }

    private fun addNodeAttr(docElement: Element) {
        val addAttr = ExtensionManager.extension?.addAttributes
        if (addAttr.isNullOrEmpty()) {
            return
        }
        val keyNodes = addAttr.keys
        keyNodes.forEach {
            //找到所有此名字的节点
            val nodeListFotTag=docElement.getElementsByTagName(it).nodeToList()
            nodeListFotTag.forEach { node->
                //遍历所有此名字的节点, 添加属性(已有此属性则不添加)
                if(node is Element){
                    val ele=node as Element
                    val nodeName = node.nodeName
                    val attrMap = addAttr[nodeName]
                    val key=attrMap?.keys?.first()
                    val vau=attrMap?.values?.first()
                    val attr = node.attributes.getNamedItem(key)
                    if (attr == null) {  //没有时才添加
                        GLog.i("addNodeAttr:node:$nodeName, $key-->" + vau)
                        ele.setAttribute(key,vau)
                    }
                }
            }
        }
    }

    private fun delNodeAttr(docElement: Element) {
        val delAttr = ExtensionManager.extension?.delAttributes
        if (delAttr.isNullOrEmpty()) {
            return
        }
        val keyNodes = delAttr.keys
        keyNodes.forEach {
            //找到所有此名字的节点
            val nodeListFotTag=docElement.getElementsByTagName(it).nodeToList()
            nodeListFotTag.forEach { node->
                //遍历所有此名字的节点, 添加属性(已有此属性则不添加)
                if(node is Element){
                    val ele=node as Element
                    val nodeName = node.nodeName
                    val delAttrKey = delAttr[nodeName]
                    val attr = node.attributes.getNamedItem(delAttrKey)
                    if (attr != null) {  //没有时才添加
                        ele.removeAttribute(delAttrKey)
                        GLog.i("delNodeAttr:node:$nodeName, $delAttrKey")
                    }
                }
            }
        }
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