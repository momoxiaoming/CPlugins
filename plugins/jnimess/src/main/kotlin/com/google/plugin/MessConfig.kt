package com.google.plugin

import com.google.gson.annotations.SerializedName

/**
 * create on 2022/5/13
 */
class MessConfig {

   @SerializedName("enable")
   var enable = true

   /**
    * native混淆配置
    */
   @SerializedName("jniInfoList")
   var jniInfoList:List<JniClassInfo>? = null

   /**
    * class中需要随机化的字符串
    */
   @SerializedName("javaStringConfig")
   var javaStringConfig:JavaStringConfig? = null


   @SerializedName("manifestConfig")
   var manifestConfig:ManifestConfig? = null

   /**
    * string.xml中需要随机化的串
    */
   @SerializedName("stringConfig")
   var stringConfig:StringsConfig? = null

   override fun toString(): String {
      return "MessConfig(\nenable=$enable, \njniInfoList=$jniInfoList, \njavaStringConfig=$javaStringConfig, \nmanifestConfig=$manifestConfig, \nstringConfig=$stringConfig)"
   }


}