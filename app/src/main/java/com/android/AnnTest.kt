package com.android

import android.util.Log

/**
 * AnnTest
 *
 * @author mmxm
 * @date 2022/1/21 17:27
 */

class AnnTest {
    var cls: List<Class<*>>? = null

    init {
        cls =
            listOf(
                com.alibaba.android.arouter.routes.`ARouter$$Root$$common`::class.java,
                com.alibaba.android.arouter.routes.`ARouter$$Group$$test`::class.java
            )
    }

    fun test() {
        Log.d("allen","1231232131231223")

    }
}