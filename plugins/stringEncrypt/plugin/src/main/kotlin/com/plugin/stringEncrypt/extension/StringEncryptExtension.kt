package com.plugin.stringEncrypt.extension

/**
 * AnnRemoveExtension
 *
 * @author mmxm
 * @date 2022/8/3 11:59
 */
open class StringEncryptExtension {

    /**
     * 日志开关
     */
    var logEnable=false

    /**
     * 需要加密的包名
     * 格式: com/test/sim
     */
    var encryptPackages: List<String>? = null

}