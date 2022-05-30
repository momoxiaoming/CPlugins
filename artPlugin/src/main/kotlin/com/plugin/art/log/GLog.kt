package com.plugin.art.log

/**
 * Log
 *
 * @author mmxm
 * @date 2022/1/25 14:09
 */
object GLog {
    private var debug:Boolean=false

    fun setDebug(debug:Boolean){
        GLog.debug =debug
    }

    fun i(msg:String){
        if(debug){
            println(msg)
        }
    }
}