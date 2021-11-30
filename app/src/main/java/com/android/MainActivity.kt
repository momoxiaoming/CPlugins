package com.android

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.android.common.MyApplication
import com.android.common.Test
import com.android.plugins.AESUtils
import com.android.plugins.PluginClassLoader
import com.android.plugins.R
import com.android.plugins.ReflectUtils
import dalvik.system.DexClassLoader
import java.io.File

/**
 * MainActivity
 *
 * @author mmxm
 * @date 2021/11/29 14:15
 */
class MainActivity : AppCompatActivity() {

    private var pluginClassLoader: DexClassLoader? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.btn).setOnClickListener {
            loadPlugin()
        }

        findViewById<Button>(R.id.btn2).setOnClickListener {
            loadCls()
        }
    }

    fun loadPlugin() {
        val files = assets.open("testapp-debug.apk")
        val file=File(filesDir,"app.apk")
        file.writeBytes(files.readBytes())
        pluginClassLoader =
            PluginClassLoader(file.path, null, null, classLoader.parent);

    }

    fun loadCls() {
        Test.test=20
        val appCls = pluginClassLoader!!.loadClass("com.android.testapp.PluginApp")
        ReflectUtils.invokeMethod(appCls.newInstance(),"attach", arrayOf(), arrayOf())
        Log.d("allen","宿主--->${Test.test}")
    }

    /**
     * 解密插件apk文件
     * @param context Context
     * @param fileName String
     * @param localPath String
     * @return File?
     */
    fun decodeFile(context: Context, fileName: String, localPath: String): File? {
        try {
            val fileBytes =
                context.assets.open(fileName).readBytes()
            val bytes = AESUtils.decrypt(fileBytes)
            if (bytes != null) {
                val file = File(localPath)
                file.writeBytes(bytes)
                return file
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}