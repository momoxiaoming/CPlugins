package com.dn.encrypt;

import com.dn.encrypt.annotation.IgnoreByteEncrypt;

import org.jetbrains.annotations.NotNull;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * DefaultEncImpl
 *
 * @author mmxm
 * @date 2022/2/14 20:26
 */
@IgnoreByteEncrypt
public class DefaultEncImpl implements IByteEncrypt
{
    public static final String MODE = "AES/CBC/PKCS5Padding";
    public static final String TRANSFORMATION = "AES";
    public static final String DEFULT_PASSWORD = "1234567890123456";
    public static final String IV = "1234567890123456";

    @Override
    public boolean canEncrypt(@NotNull String value)
    {
        return false;
    }

    @NotNull
    @Override
    public byte[] encrypt(@NotNull String value)
    {
        try
        {
            Cipher cipher = Cipher.getInstance(MODE);
            SecretKeySpec key = new SecretKeySpec(DEFULT_PASSWORD.getBytes(), TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
            byte[] bt = cipher.doFinal(value.getBytes("UTF-8"));
            return bt;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @NotNull
    @Override
    public String decrypt(@NotNull byte[] value)
    {
        try
        {
            Cipher cipher = Cipher.getInstance(MODE);
            SecretKeySpec key = new SecretKeySpec(DEFULT_PASSWORD.getBytes(), TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
            byte[] bt = cipher.doFinal(value);
            return new String(bt);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
