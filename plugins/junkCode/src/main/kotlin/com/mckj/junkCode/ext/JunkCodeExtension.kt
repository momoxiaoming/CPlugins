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
    var logEnable = true
    /**
     * 最大的manifest垃圾节点数量,
     * 此数量只是一种组件的数量, 支持mata-data, activity, service
     */
    var maxManifestJunkNodeNum = 10

    /**
     * 最大的随机生成的包名个数
     */
    var maxRandomPackageNum = intArrayOf(10,20)

    /**
     * 最大随机生成的垃圾类数量
     */
    var maxRandomClassCount = intArrayOf(20,500)

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
    var maxJunkCodeFunToModify = 0

    /**
     * 最多垃圾字段数
     */
    var maxJunkCodeFields = 6

    /**
     * 需要插入垃圾代码的包名
     */
    var junkPackages = arrayListOf<String>()


    /**
     * 生成drawable数量
     */
    var maxDrawableResCount= intArrayOf(2,20)

    /**
     * 生成String数量
     */
    var maxStringResCount= intArrayOf(2,20)

    /**
     * 生成layout数量
     */
    var maxLayoutResCount= intArrayOf(2,20)


    /**
     * 生成Color数量
     */
    var maxColorResCount= intArrayOf(2,20)

    /**
     * 生成style数量
     */
    var maxStyleResCount= intArrayOf(2,20)

    /**
     * 生成的assets文件夹数量
     */
    var maxAssetsDirCount= intArrayOf(2,10)

    /**
     * 生成的assets文件夹中文件数量
     */
    var maxAssetsDirFileCount= intArrayOf(2,10)

    /**
     * 单个assets文件内容大小
     */
    var maxAssetFileSize=intArrayOf(500,10240)
}