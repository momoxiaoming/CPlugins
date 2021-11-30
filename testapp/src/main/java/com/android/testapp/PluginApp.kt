package com.android.testapp

import android.util.Log
import com.android.common.MyApplication
import com.android.common.Test

/**
 * PluginApp
 *
 * @author mmxm
 * @date 2021/11/29 17:03
 */
class PluginApp :MyApplication() {

    override fun onCreate() {
        super.onCreate()
        Log.d("allen","PluginApp  onCreate")
        Log.d("allen","PluginApp  --->${Test.test}")


    }
}