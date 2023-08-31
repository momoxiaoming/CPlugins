package com.plugin.stringEncrypt.helpr

import com.plugin.stringEncrypt.extension.ExtensionManager


fun log(msg:String){
    if(ExtensionManager.extension.logEnable){
        println("stringEncrypt-->"+msg)
    }
}