package com.android.lib.string.decrypt;

import java.nio.charset.StandardCharsets;

/**
 * create on 2021/9/27
 */
public class HexDecryptUtils {
    static {
        System.loadLibrary("a");
    }

    public static String decrypt(byte[] bytes, int keys) {
//原始解码
//        byte[] originbytes = bytes.clone();
//        int len = bytes.length;
//        for (int i = len-1; i>0; i--) {
//            bytes[i] = (byte)((bytes[i] ^ bytes[i - 1]));
//        }
//        bytes[0] = (byte)((bytes[0] ^ Integer.valueOf(keys).byteValue()));
//

//测试 java层解码
//        byte[] originbytes = bytes.clone();
//        int len = bytes.length;
//        keys =(keys * keys * keys) << 1;
//        int pos;
//
//        for (int i = len-1; i>0; i--) {
//            if (i % 2 == 0) {
//                pos = (i * i) >> 1;
//            } else {
//                pos = (i * i * i) >> 1;
//            }
//            bytes[i] = (byte)((bytes[i] ^ bytes[i - 1])^ pos);
//        }
//
//        bytes[0] = (byte)((bytes[0] ^ Integer.valueOf(keys).byteValue()));
//        String str =new String(bytes, StandardCharsets.UTF_8);
//        System.out.println("java decrypt--------------: " + str);
//        byte[] bytes1 = a(originbytes, keys);
//        return str;


//native
        byte[] bytes1 = a(bytes, keys);
        String result = new String(bytes1, StandardCharsets.UTF_8);
//        System.out.println("decrypt--------------: " + result);
        return result;
//        return new String(bytes1, StandardCharsets.UTF_8);
    }

    public static native byte[] a(byte[] arr, int key);

}
