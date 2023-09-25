package com.plugin.manifest_edit.log

import com.plugin.manifest_edit.extension.ExtensionManager

/**
 * Log
 *
 * @author mmxm
 * @date 2022/1/25 14:09
 */
object GLog {
    fun i(msg:String){
        if(ExtensionManager.extension?.logEnable==true){
            println("minifest_edit: $msg")
        }
    }
}