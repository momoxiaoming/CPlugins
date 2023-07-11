package com.android.test123

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.android.AnnTest
import com.android.TestFragment
import com.android.TestPhoneCall
import com.android.plugins.R

/**
 * MainActivity2
 *
 * @author mmxm
 * @date 2022/2/11 16:14
 */
@Route(path = "/app/activity/splash")
class MainActivity2 :AppCompatActivity(){
     val test2="test23"
    companion object{
        const val TAG="MainActivity2"
        val test3="test3"
    }
    val fragment= TestFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
//        val explode: Transition =
//            TransitionInflater.from(this).inflateTransition(android.R.transition.explode)
//        window.enterTransition = explode
        setContentView(R.layout.activity_main)
        AnnTest().test()
        findViewById<Button>(R.id.btn).setOnClickListener {
            ARouter.getInstance().build("/test/arouter").navigation()
            ARouter.getInstance().build("/main/action").navigation()
        }
        val call= TestPhoneCall()
        call.init(this)
        call.addPhoneCallListener()

        test1()
        test2()
        test3()
        test4()
    }

    fun test1(){
        Log.d(TAG, "test1: tetwetet")
    }
    fun test2(){
        Log.d(TAG, "test1: tetwetet")
    }
    fun test3(){
        Log.d(TAG, "test1: tetwetet")
    }
    fun test4(){
        Log.d(TAG, "test1: tetwetet")
    }
}