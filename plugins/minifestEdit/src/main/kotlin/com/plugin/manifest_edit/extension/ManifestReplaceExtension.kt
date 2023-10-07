package com.plugin.manifest_edit.extension


open class ManifestReplaceExtension {

    /**
     * 日志开关
     */
    var logEnable=false
    /**
     * 需要替换的节点,以及其中的属性
     * 比如: {activity   [{android:excludeFromRecents  true}] }
     *
     */
    var replaceAttributes: HashMap<String,HashMap<String,String>>? = null

    /**
     * 需要添加的节点属性
     */
    var addAttributes: HashMap<String,HashMap<String,String>>? = null


    /**
     * 需要删除的节点属性
     */
    var delAttributes: HashMap<String,String>? = null
}