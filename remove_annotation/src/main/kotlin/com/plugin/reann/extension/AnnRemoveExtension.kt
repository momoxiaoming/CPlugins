package com.plugin.reann.extension

/**
 * AnnRemoveExtension
 *
 * @author mmxm
 * @date 2022/8/3 11:59
 */
open class AnnRemoveExtension {
    /**
     * 需要移除注解的包类名
     */
    var removePkgName: List<String>? = null

    /**
     * 需要移除的注解类的父类名称
     */
    var removeParentClsName: List<String>? = null

    /**
     * 需要移除的注解名
     */
    var removeAnnClsName: List<String>? = null


    fun getRemovePkg(): List<String>? {
        return removePkgName?.map {
            it.replace(".", "/")
        }
    }

    fun getAnnList():List<String>?{
        return removeAnnClsName?.map {
            "L${it.replace(".", "/")};"
        }
    }
}