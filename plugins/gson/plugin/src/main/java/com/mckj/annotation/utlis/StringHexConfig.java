package com.mckj.plugin.common.utils;


/* loaded from: classes3.dex */
public class StringHexConfig {

    public static byte[] encrypt(byte[] bytes, int keys) {
        if (bytes == null) {
            return null;
        }
        int len = bytes.length;
        int key = keys;
        for (int i = 0; i < len; i++) {
            bytes[i] = (byte) (bytes[i] ^ key);
            key = bytes[i];
        }
        return bytes;
    }

    public static byte[] decrypt(byte[] bytes, Integer keys) {
        int len = bytes.length;
        for (int i = len - 1; i > 0; i--) {
            bytes[i] = (byte) (bytes[i] ^ bytes[i - 1]);
        }
        bytes[0] = (byte) (bytes[0] ^ keys.byteValue());
        return bytes;
    }
}