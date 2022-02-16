package com.dn.encrypt;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 插件实际调用的加密类
 * 传入的是插件实现类的类全路径
 *
 * @author mmxm
 * @date 2022/2/15 11:01
 */
public final class ByteEncryptWrapper implements IByteEncrypt
{
    private IByteEncrypt impl;
    private String encryptCls;

    public ByteEncryptWrapper(String encryptCls)
    {
        this.encryptCls=encryptCls;
//        try
//        {
//            impl = (IByteEncrypt) Class.forName(encryptCls).newInstance();
//        } catch (ClassNotFoundException e) {
//            throw new IllegalArgumentException(encryptCls+" implementation class not found: " + encryptCls);
//        } catch (InstantiationException e) {
//            throw new IllegalArgumentException(encryptCls+" implementation class new instance failed: "
//                    + e.getMessage());
//        } catch (IllegalAccessException e) {
//            throw new IllegalArgumentException(encryptCls+" implementation class access failed: "
//                    + e.getMessage());
//        }
    }

    @Nullable
    @Override
    public byte[] encrypt(@NotNull String value)
    {
        try
        {
            impl = (IByteEncrypt) Class.forName(encryptCls).newInstance();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }


        return impl==null?null:impl.encrypt(value);
    }

    @NotNull
    @Override
    public String decrypt(@NotNull byte[] value)
    {

        try
        {
            impl = (IByteEncrypt) Class.forName(encryptCls).newInstance();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return impl==null?"":impl.decrypt(value);
    }

    @Override
    public boolean canEncrypt(@NotNull String value)
    {
        return true;
    }
}
