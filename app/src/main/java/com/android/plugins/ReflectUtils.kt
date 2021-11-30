package com.android.plugins

import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * ReflectUtils
 *
 * @author mmxm
 * @date 2021/10/25 11:51
 */
object ReflectUtils {


    private fun getPubMethod(
        cls: Class<*>,
        methodNm: String,
        vararg arg: Class<*>
    ): Method? {
        try {
            return cls.getMethod(methodNm, *arg)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    private fun getDelMethod(
        cls: Class<*>,
        methodNm: String,
        vararg arg: Class<*>
    ): Method? {
        try {
            val method = cls.getDeclaredMethod(methodNm, *arg)
            method.isAccessible = true
            return method
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    private fun getMethod(
        cls: Class<*>,
        methodNm: String,
        vararg arg: Class<*>
    ): Method? {
        try {
            var method = getDelMethod(cls, methodNm, *arg)
            if (method == null) {
                method = getPubMethod(cls, methodNm, *arg)
            }
            return method
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    private fun getAccessibleField(
        cls: Class<*>,
        fieldNm: String,
    ): Field? {
        try {
            val field = cls.getDeclaredField(fieldNm)
            field.isAccessible = true
            return field
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * 反射方法
     * @param methodObj Any
     * @param methodNm String
     * @param argObj Array<Any>
     * @param arg Array<out Class<*>>
     * @return Any?
     */
    fun invokeMethod(
        methodObj: Any,
        methodNm: String,
        argObj: Array<Any>,
        arg: Array<Class<*>>
    ): Any? {
        try {
            val method = getMethod(methodObj.javaClass, methodNm, *arg)
            return method?.invoke(methodObj, *argObj)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * 反射方法
     * @param methodObj Any
     * @param methodNm String
     * @param argObj Array<Any>
     * @param arg Array<out Class<*>>
     * @return Any?
     */
    fun invokeStaticMethod(
        methodCls: Class<*>,
        methodNm: String,
        argObj: Array<Any>,
        arg: Array<Class<*>>
    ): Any? {
        try {
            val method = getMethod(methodCls, methodNm, *arg)
            return method?.invoke(null, *argObj)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * 反射变量
     * @param fieldObj Any
     * @param fieldNm String
     * @return Any?
     */
    fun getField(
        fieldObj: Any,
        fieldNm: String
    ): Any? {
        val field = getAccessibleField(fieldObj.javaClass, fieldNm)
        return field?.get(fieldObj)
    }
    /**
     * 反射变量
     * @param fieldObj Any
     * @param fieldNm String
     * @return Any?
     */
    fun getStaticField(
        fieldCls: Class<*>,
        fieldNm: String
    ): Any? {
        val field = getAccessibleField(fieldCls, fieldNm)
        return field?.get(null)
    }
    /**
     * 反射变量
     * @param fieldObj Any
     * @param fieldNm String
     * @return Any?
     */
    fun setField(
        obj: Any,
        fieldNm: String,
        fieldObj: Any?
    ) {
        val field = getAccessibleField(obj.javaClass, fieldNm)
        field?.set(obj, fieldObj)
    }
}