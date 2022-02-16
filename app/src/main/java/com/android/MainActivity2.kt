package com.android

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.android.plugins.R

/**
 * MainActivity2
 *
 * @author mmxm
 * @date 2022/2/11 16:14
 */
class MainActivity2 :AppCompatActivity(){
     val test2="test23"
    companion object{
        const val TAG="MainActivity2"
        val test3="test3"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn).setOnClickListener {
            Log.d(TAG,"----->---")
        }
        println("---->$test3")
//       val bt= RuntimeByteEncryptImpl.encrypt("allen")
//        Log.d("allen","----->---$bt")
//
//        val de= RuntimeByteEncryptImpl.decrypt(bt)
//        Log.d("allen","----->---$de")


//        val bt1= AESUtils.encrypt("allen")
//        Log.d("allen","----->---$bt1")
//
//        val de1= AESUtils.decrypt(bt1!!)
//        Log.d("allen","----->---${de1!!.decodeToString()}")
    }
}