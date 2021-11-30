package com.android.plugins

import android.util.Log
import dalvik.system.DexClassLoader

/**
 * PluginClassLoader
 *
 * @author mmxm
 * @date 2021/11/29 16:55
 */
class PluginClassLoader(
    dexPath: String?, optimizedDirectory: String?, librarySearchPath: String?,
    parent: ClassLoader?
) : DexClassLoader(
    dexPath,
    optimizedDirectory, librarySearchPath, parent
) {

//    override fun loadClass(name: String?): Class<*> {
//        try {
//           return findClass(name)
//        } catch (e: Exception) {
//            Log.e("PluginClassLoader","findClass--未找到该类--->$name")
//        }
//        return super.loadClass(name)
//    }
}