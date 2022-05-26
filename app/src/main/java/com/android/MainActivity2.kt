package com.android

import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionInflater
import android.util.Log
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.template.IProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.android.plugins.R

/**
 * MainActivity2
 *
 * @author mmxm
 * @date 2022/2/11 16:14
 */
@Route(path = "/main/action")
class MainActivity2 :AppCompatActivity(){
     val test2="test23"
    companion object{
        const val TAG="MainActivity2"
        val test3="test3"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        val explode: Transition =
            TransitionInflater.from(this).inflateTransition(android.R.transition.explode)
        window.enterTransition = explode
        setContentView(R.layout.activity_main)
        AnnTest().test()
        findViewById<Button>(R.id.btn).setOnClickListener {
            ARouter.getInstance().build("/test/arouter").navigation()
            ARouter.getInstance().build("/main/action").navigation()
        }
        Log.d("allen","com.alibaba.android.arouter.routes")

    }


}