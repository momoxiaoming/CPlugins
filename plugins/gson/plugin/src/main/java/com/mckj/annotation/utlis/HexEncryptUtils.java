package com.mckj.annotation.utlis;

public class HexEncryptUtils {

    public static byte[] encrypt(byte[] bytes, int keys) {
        if (bytes == null) {
            return null;
        }
        int len = bytes.length;
        int key = (keys * keys * keys) << 1;
        int pos;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                pos = (i * i) >> 1;
            } else {
                pos = (i * i * i) >> 1;
            }
            key = key ^ (pos);
            bytes[i] = (byte) (bytes[i] ^ key);
            key = bytes[i];
        }
        return bytes;
    }
}
