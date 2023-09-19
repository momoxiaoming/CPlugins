package com.plugin.ads.log

import com.plugin.ads.extension.ExtensionManager

/**
 * Log
 *
 * @author mmxm
 * @date 2022/1/25 14:09
 */
object GLog {
    fun i(msg:String){
        if(ExtensionManager.extension?.logEnable==true){
            println("art: $msg")
        }
    }
}