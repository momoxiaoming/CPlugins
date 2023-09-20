package com.mckj.annotation.tools;

import android.util.Log;

import com.android.lib.string.decrypt.HexDecryptUtils;
import com.google.gson.FieldNamingStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public enum VFieldNameStrategy implements FieldNamingStrategy {
//    DEFAULT() {
//        private static final String TAG = "json:strategy";
//
//        @Override
//        public String translateName(Field f) {
//            Annotation[] annotations = f.getDeclaredAnnotations();
//            for (Annotation annotation : annotations) {
////                if (annotation instanceof SafeSerializedName) {
//                String value = ((SafeSerializedName) annotation).value();
//                Log.d(TAG, "translateName: start translate [" + value + "]");
//                int separatorIndex = value.lastIndexOf("#");
//                Log.d(TAG, "translateName: separatorIndex [" + separatorIndex + "]");
//                if (separatorIndex != -1) {
//                    try {
//                        String password = value.substring(separatorIndex + 1, value.length());
//                        String b_real = value.substring(0, separatorIndex);
//                        Log.d(TAG, "translateName: password" + "[" + password + "], real" + "[" + b_real + "]");
//                        String s_real = new String(StringHexConfig.decrypt(b_real.getBytes(), Integer.parseInt(password)));
//                        Log.d(TAG, "translateName: result[" + s_real + "]");
//                        return s_real;
//                    } catch (StringIndexOutOfBoundsException exception) {
//                        Log.e(TAG, "translateName: parse failed >> " + exception.getMessage());
//                        return f.getName();
//                    } catch (NumberFormatException exception) {
//                        Log.e(TAG, "translateName: password transformation failed >> " + exception.getMessage());
//                    } catch (UnsupportedOperationException exception) {
//                        Log.e(TAG, "translateName: s_real transformation failed >> " + exception.getMessage());
//                    }
//                }
//            }
////            }
//
//
//            return f.getName();
//        }
//    }

    DEFAULT() {
        private static final String TAG = "json:strategy";

        @Override
        public String translateName(Field f) {
            Annotation[] annotations = f.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof EncryptSerializedName) {
                    try {
                        byte[] value = ((EncryptSerializedName) annotation).value();
                        int password = value[value.length - 1];
                        Log.d(TAG, "translateName: start translate [" + new String(value) + "], password[" + password + "]");
                        byte[] encryptValue = new byte[value.length - 1];
                        System.arraycopy(value, 0, encryptValue, 0, value.length - 1);
                        String s_real = HexDecryptUtils.decrypt(encryptValue, password);
                        Log.d(TAG, "translateName: result[" + s_real + "]");
                        return s_real;
                    } catch (Exception exception) {
                        Log.e(TAG, "translateName: failed >> " + exception.getMessage());
                    }

                }
            }
            return f.getName();
        }
    }

}
