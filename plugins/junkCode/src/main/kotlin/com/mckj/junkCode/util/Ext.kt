package com.mckj.junkCode.util

import com.mckj.junkCode.ext.ExtensionManager

/**
 * Ext
 *
 * @author mmxm
 * @date 2023/7/17 9:30
 */

fun logI(msg:String){
    if(ExtensionManager.extension?.logEnable==true){
        println("junkCode: $msg")
    }
}