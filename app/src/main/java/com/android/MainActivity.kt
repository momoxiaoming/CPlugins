package com.android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.plugins.AESUtils

/**
 * MainActivity
 *
 * @author mmxm
 * @date 2021/11/29 14:15
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val rlt =AESUtils.decrypt(AESUtils.parseHexStr2Byte("D386E65073F7D977B982C094FF94456F222C643E73AEAE7FF75878C0978613B9"))

        val rlt2 =AESUtils.encrypt("hdl_com.m.c.aos.app-1.apk")

        Log.d("allen", "rlt---->${String(rlt!!)}");

        Log.d("allen", "rlt加密---->${AESUtils.parseByte2HexStr(rlt2)}");

    }
}