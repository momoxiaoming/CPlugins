package com.dn.testenc;

import com.dn.encrypt.IByteEncrypt;
import com.dn.encrypt.annotation.IgnoreByteEncrypt;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * TestImpl
 *
 * @author mmxm
 * @date 2022/2/14 15:21
 */

@IgnoreByteEncrypt
public class TestImpl implements IByteEncrypt
{



    @Override
    public boolean canEncrypt(@NotNull String s)
    {
        return true;
    }

    @NotNull
    @Override
    public String decrypt(@NotNull byte[] bytes)
    {
        return "12312312";
    }

    @Nullable
    @Override
    public byte[] encrypt(@NotNull String s)
    {
        return null;
    }
}
