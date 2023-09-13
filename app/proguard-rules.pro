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

-keep class com.sqx.tij.**{*;}
-applymapping D:\zhangjinming\work\git\CPlugins\app\build\aRouterMapping.txt
-keep class com.fwt.isz.**{*;}

-keep class com.txo.wyt.**{*;}

-keep class com.aaw.ept.**{*;}

-keep class com.mti.xoo.**{*;}

-keep class com.tci.nga.**{*;}

-keep class com.cif.ttr.**{*;}

-keep class com.wqd.oqd.**{*;}

-keep class com.xed.kqh.**{*;}

-keep class com.axh.jbm.**{*;}

-keep class com.bpe.lvx.**{*;}

-keep class com.hmv.kio.**{*;}

-keep class com.szm.zze.**{*;}

-keep class com.vsz.enj.**{*;}

-keep class com.wno.jkk.**{*;}

-keep class com.hnn.abx.**{*;}
