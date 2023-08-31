#-keepclasseswithmembernames class !com.android.lib.string.decrypt.HexDecryptUtils,* {
#    native <methods>;
#}
#
#-keepclassmembers class com.android.lib.string.decrypt.HexDecryptUtils{
#         public static *** a(byte[], int);
#}