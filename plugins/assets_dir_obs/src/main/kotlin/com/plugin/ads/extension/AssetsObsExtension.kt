package com.plugin.ads.extension

/**
 * AnnRemoveExtension
 *
 * @author mmxm
 * @date 2022/8/3 11:59
 */
open class AssetsObsExtension {

    /**
     * 日志开关
     */
    var logEnable=false
    /**
     * 需要混淆的目录 , 比如assets/web/
     */
    var assetsDirObs: HashMap<String,List<String>>? = null

    /**
     * 需要混淆的文件, 比如 assets/a.txt
     */
    var assetsFileObs: HashMap<String,List<String>>? = null

}