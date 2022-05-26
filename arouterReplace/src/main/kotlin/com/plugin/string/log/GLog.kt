package com.plugin.string.log

/**
 * Log
 *
 * @author mmxm
 * @date 2022/1/25 14:09
 */
object GLog {
    private var debug:Boolean=true

    fun setDebug(debug:Boolean){
        this.debug=debug
    }

    fun i(msg:String){
        if(debug){
            println(msg)
        }
    }
}