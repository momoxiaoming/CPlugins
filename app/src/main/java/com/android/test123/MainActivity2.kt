package com.android.test123

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.android.plugins.R
import java.nio.charset.Charset
import com.stickman.jump.server.NanoServer
/**
 * MainActivity2
 *
 * @author mmxm
 * @date 2022/2/11 16:14
 */
@Route(path = "/app/activity/splash")
class MainActivity2 : AppCompatActivity() {
    val test2 = "test23"

    companion object {
        const val TAG = "MainActivity2"
        val test3 = "test3"
    }

    val fragment = TestFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
//        val explode: Transition =
//            TransitionInflater.from(this).inflateTransition(android.R.transition.explode)
//        window.enterTransition = explode
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn).setOnClickListener {
//            ARouter.getInstance().build("/test/arouter").navigation()
//            ARouter.getInstance().build("/main/action").navigation()
            test1()
        }
//        val call= TestPhoneCall()
//        call.init(this)
//        call.addPhoneCallListener()
        NanoServer
        test1()
        test2()
        test3()
        test4()
    }

    fun test1() {
        val str = "testhello"
        val key = 4
        val strByte = str.toByteArray(Charset.defaultCharset())
        Log.d(TAG, "加密前: ${strByte.contentToString()}")
        val encrypt = encrypt(strByte, key)
        Log.d(TAG, "加密后: ${encrypt.contentToString()}")
        val decrypt = decrypt(encrypt, -key)
        Log.d(TAG, "解密: ${decrypt.contentToString()}")
        Log.d(TAG, "解密: ${decrypt.toString(Charset.defaultCharset())}")

    }

    fun test2() {
        Log.d(TAG, "test1: tetwetet")


    }

    fun test3() {
        Log.d(TAG, "test1: tetwetet")
    }

    fun test4() {
        Log.d(TAG, "test1: tetwetet")
    }


    fun decrypt(data: ByteArray, key: Int): ByteArray {
        val result = ByteArray(data.size)
        for (i in data.indices) {
            var opt = data[i].toInt()
            opt = opt xor data.size
            opt += key
            opt = if (i % 2 == 0) {  //位运算
                opt shl  1
            } else {
                opt shr 1
            }
            result[i] = opt.toByte()
        }
        return result
    }

    fun encrypt(data: ByteArray, key: Int): ByteArray {
        val result = ByteArray(data.size)
        for (i in data.indices) {
            var opt = data[i].toInt()
            opt = if (i % 2 == 0) {  //位运算
                opt shr 1
            } else {
                opt shl 1
            }
            opt += key  //位移运算
            opt = opt xor data.size  //与或运算
            result[i] = opt.toByte()
        }
        return result

//        val len = data.size
//        var key = keys * keys * keys shl 1
//        var pos: Int
//        for (i in 0 until len) {
//            pos = if (i % 2 == 0) {
//                i * i shr 1
//            } else {
//                i * i * i shr 1
//            }
//            key = key xor pos
//            data[i] = (data[i].toInt() xor key).toByte()
//            key = data[i].toInt()
//        }
//        return data
    }


}