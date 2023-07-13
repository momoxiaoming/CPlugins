package com.mckj.junkCode.ext

/**
 * JunkCodeExtension
 *
 * @author mmxm
 * @date 2023/7/7 18:23
 */
open class JunkCodeExtension {

    /**
     * 最大的manifest垃圾节点数量,
     * 此数量只是一种组件的数量, 支持mata-data, activity, service
     */
    var maxManifestJunkNodeNum = 10

    /**
     * 最大的随机生成的包名个数
     */
    var maxRandomPackageNum = arrayOf(10,20)

    /**
     * 最大随机生成的垃圾类数量
     */
    var maxRandomClassCount = 100

    /**
     * 最大随机生成的类的方法数量
     */
    var maxRandomMethodCount = 10


    /**
     * 最大随机生成的类的field数量
     */
    var maxRandomFieldCount = 10

    /**
     * 垃圾方法最大个数
     */
    var maxJunkCodeFunOfPerClass = 5

    /**
     * 最多可以插入垃圾代码的方法个数
     */
    var maxJunkCodeFunToModify = 5

    /**
     * 最多垃圾字段数
     */
    var maxJunkCodeFields = 6

    /**
     * 需要插入垃圾代码的包名
     */
    var junkPackages = arrayListOf<String>()


}