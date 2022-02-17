最新版: 1.0.3

根 build.gradle中添加: classpath "com.android.plugin:byteEncrypt:1.0.3"

在模块中添加
apply plugin: 'com.gradle.plugin.byteEncrypt'
byteEncrypt {
    /**
     * 开关
     */
    enable true
    /**
     * 包名过滤,若此项为空,将默认全部
     */
    encryptPackages =["com.android.plugins"]
}