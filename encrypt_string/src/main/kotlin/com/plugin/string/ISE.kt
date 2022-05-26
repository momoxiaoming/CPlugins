package com.plugin.string

/**
 * 自定义加密基础的接口
 *
 * @author mmxm
 * @date 2022/1/21 16:50
 */
interface ISE {
    /**
     * 加密
     */
    fun encode()

    /**
     * 解密
     */
    fun decode()
}