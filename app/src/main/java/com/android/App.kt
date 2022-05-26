package com.android

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.android.plugins.BuildConfig

/**
 * App
 *
 * @author mmxm
 * @date 2022/5/18 19:36
 */
class App :Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}