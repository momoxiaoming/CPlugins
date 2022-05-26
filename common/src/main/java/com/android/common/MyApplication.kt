package com.android.common

import android.app.Application
import android.util.Log
import androidx.annotation.Keep

/**
 * MyApplication
 *
 * @author mmxm
 * @date 2021/11/29 17:03
 */
@Keep
open class MyApplication :Application() {
    fun attach(){
        Log.d("allen","PluginApp  attach")
        Log.d("allen","com.alibaba.android.arouter.routes")
        onCreate()
    }
}