package com.mckj.junkCode.ext

import kotlin.random.Random

/**
 * Ext
 *
 * @author mmxm
 * @date 2023/8/31 11:29
 */


fun randomForArray(array: IntArray?): Int {
    return if (array != null && array.size == 2) {
        Random.nextInt(array[0], array[1])
    } else {
        0
    }
}