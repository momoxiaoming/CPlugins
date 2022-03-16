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
    public static final byte[] MODE = new byte[]{65,69,83,47,67,66,67,47,80,75,67,83,53,80,97,100,100,105,110,103};
    public static final byte[] TRANSFORMATION = new byte[]{65,69,83};
//    public static final byte[] DEFULT_PASSWORD = new byte[]{49,50,51,52,53,54,55,56,57,48,49,50,51,52,53,54};
    public static final byte[] IV = new byte[]{54,53,52,51,50,49,48,57,56,55,54,53,52,51,50,49};

    @Override
    public boolean canEncrypt(@NotNull String value)
    {
        return true;
    }

    @NotNull
    @Override
    public byte[] encrypt(@NotNull byte[] pwd,@NotNull String value)
    {
        try
        {
            Cipher cipher = Cipher.getInstance(new String(MODE));
            SecretKeySpec key = new SecretKeySpec(pwd, new String(TRANSFORMATION));
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV));
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
    public String decrypt(@NotNull byte[] pwd,@NotNull byte[] value)
    {
        try
        {
            Cipher cipher = Cipher.getInstance(new String(MODE));
            SecretKeySpec key = new SecretKeySpec(pwd, new String(TRANSFORMATION));
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV));
            byte[] bt = cipher.doFinal(value);
            return new String(bt);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
