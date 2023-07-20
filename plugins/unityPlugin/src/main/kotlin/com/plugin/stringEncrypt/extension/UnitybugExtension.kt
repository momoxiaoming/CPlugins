package com.plugin.stringEncrypt.extension

/**
 * AnnRemoveExtension
 *
 * @author mmxm
 * @date 2022/8/3 11:59
 */
open class UnitybugExtension {
    /**
     * 需要移除的类 以及类中的方法名
     */
    var classAndMethod: HashMap<String,List<String>>? = null

    fun getRemoveClass(): List<String>? {
        return classAndMethod?.keys?.map {
            it.replace(".", "/")
        }
    }


    fun getMethods(className:String):List<String>?{
        return classAndMethod?.get(className.replace("/","."))
    }
}