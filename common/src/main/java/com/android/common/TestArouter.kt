package com.android.common

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * TestArouter
 *
 * @author mmxm
 * @date 2022/5/18 19:35
 */
@Route(path = "/test/arouter")
class TestArouter :IProvider {
    override fun init(p0: Context?) {
        Log.d("allen","TestArouter")
    }
}