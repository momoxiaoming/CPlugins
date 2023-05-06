package com.android

import android.content.Context
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.util.Log

/**
 * TestPhoneCall
 *
 * @author mmxm
 * @date 2023/5/6 12:21
 */
class TestPhoneCall {
    private lateinit var m_TelephonyManager: TelephonyManager


    fun init(context: Context) {
        m_TelephonyManager = context.getSystemService("phone") as TelephonyManager
    }

    fun addPhoneCallListener() {
        Log.i("TestPhoneCall", "addPhoneCallListener: start")
        this.m_TelephonyManager.listen(TestPhoneStateListener(), 32)
        Log.i("TestPhoneCall", "addPhoneCallListener: end")
    }

    private class TestPhoneStateListener : PhoneStateListener() {
        override fun onCallStateChanged(var1: Int, var2: String) {
        }
    }
}