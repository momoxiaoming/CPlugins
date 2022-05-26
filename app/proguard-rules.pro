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


-keep class fjd.zyd.bmz.**{*;}
-keep class lgv.vvi.qty.**{*;}
-keep class com.alibaba.android.arouter.routes.ARouter$$Root$$arouterapi
-keep class com.alibaba.android.arouter.routes.ARouter$$Providers$$arouterapi
-keep class com.alibaba.android.arouter.routes.ARouter$$Group$$arouter
-applymapping D:\zhangjinming\work\git\CPlugins\app\aRouterMapping.txt
-keep class uab.pxt.ctb.**{*;}
-keep class jes.rrh.mty.**{*;}
-keep class nly.art.wgd.**{*;}
-keep class hnd.pzo.gtb.**{*;}
-keep class iqk.oqc.dxt.**{*;}
-keep class hhv.adq.sln.**{*;}
-keep class xfp.rov.vpo.**{*;}
-keep class azj.gom.cih.**{*;}
-keep class nau.lnx.uab.**{*;}
-keep class xjl.ptg.bas.**{*;}
-keep class nxl.nna.wrg.**{*;}
-keep class crb.uxn.fqa.**{*;}
-keep class qsc.rcz.nnc.**{*;}
-keep class eqr.hcb.fru.**{*;}
-keep class ymm.clk.knr.**{*;}
-keep class jdb.gim.xoe.**{*;}
-keep class ogi.pvr.iev.**{*;}
-keep class ulr.xir.ebg.**{*;}
-keep class asi.azc.ado.**{*;}
-keep class qgn.vog.uco.**{*;}
-keep class jdu.bht.yau.**{*;}
-keep class syc.swo.rsg.**{*;}
-keep class kyt.bsv.xif.**{*;}
-keep class gla.fxr.jvv.**{*;}
-keep class bbn.dft.dxk.**{*;}
-keep class oso.fhi.fxo.**{*;}
-keep class qis.wtt.enw.**{*;}
-keep class fwe.gnf.orm.**{*;}
-keep class xbz.wfb.hxs.**{*;}
-keep class vwr.kem.alj.**{*;}
-keep class fet.ztb.vju.**{*;}
-keep class ywf.hlf.qhu.**{*;}
-keep class tcy.kog.ois.**{*;}
-keep class xls.yax.ojg.**{*;}
-keep class mcq.yjz.mwa.**{*;}
-keep class rza.juq.unm.**{*;}
-keep class rci.ulq.wpn.**{*;}
-keep class kad.xug.ngd.**{*;}
-keep class oxa.ltz.whg.**{*;}
-keep class zgn.eww.zcy.**{*;}
-keep class tsl.uzn.ksc.**{*;}
-keep class tau.dns.fzo.**{*;}
-keep class hgu.lht.ofu.**{*;}
-keep class hbm.ddh.rwb.**{*;}
-keep class lwa.nry.zor.**{*;}
-keep class zsp.ngo.jam.**{*;}
-keep class olh.apa.qgt.**{*;}
-keep class xhq.gqd.fsy.**{*;}
-keep class zvi.kcn.ofh.**{*;}
-keep class ery.zcd.uxb.**{*;}
-keep class kvx.gia.zlu.**{*;}
-keep class vom.ydi.lef.**{*;}