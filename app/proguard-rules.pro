# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#ARouter
-keep  class com.alibaba.android.arouter.core.**{*;}
-keep public class com.alibaba.android.arouter.facade.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}
# If you use the byType method to obtain Service, add the following rules to protect the interface:
-keepclassmembers interface * implements com.alibaba.android.arouter.facade.template.IProvider{*;}




-keep class abw.qnz.gwr.**{*;}
-keep class com.alibaba.android.arouter.routes.ARouter$$Root$$arouterapi
-keep class com.alibaba.android.arouter.routes.ARouter$$Providers$$arouterapi
-keep class com.alibaba.android.arouter.routes.ARouter$$Group$$arouter
-applymapping D:\zhangjinming\work\git\CPlugins\app\aRouterMapping.txt
-keep class xsg.imf.zhs.**{*;}