package res.gradle.plugin.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

import static org.codehaus.groovy.runtime.StringGroovyMethods.multiply;

/**
 * AESUtils
 *
 * @author mmxm
 * @date 2021/11/26 16:21
 */
public class AESUtils
{
    private static String MODE = "";//加密模式

    private static String TRANSFORMATION = "AES";

    private static String DEFULT_PASSWORD = "";  //

    private static byte[] IV = null;  //


    public static void init(String mode,String key,String iv){
        MODE=mode;
        DEFULT_PASSWORD=key;
        IV=padRight(iv,16).getBytes();
    }

    /**
     * AES加密
     *密码必须为16位或者32位,也就是16个字母或者32个字母
     * @param
     * @param content                       加密的字符串
     * @returnblank
     */
    public static byte[] encrypt(String content)
    {
        try
        {
            // 创建AES秘钥
            // 初始化加密器
            SecretKeySpec secretKeySpec = new SecretKeySpec(DEFULT_PASSWORD.getBytes(),
                    TRANSFORMATION);
            Cipher cipher=Cipher.getInstance(MODE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(IV));
            return cipher.doFinal(content.getBytes());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES加密
     *
     * @param
     * @param content 加密的字符串
     * @return
     */
    public static byte[] encrypt(byte[] content)
    {
        try
        {
            // 创建AES秘钥
            // 初始化加密器
            SecretKeySpec secretKeySpec = new SecretKeySpec(DEFULT_PASSWORD.getBytes(),
                    TRANSFORMATION);
            Cipher cipher=Cipher.getInstance(MODE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec,new IvParameterSpec(IV));
            return cipher.doFinal(content);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES解密
     *
     * @param
     * @param content 加密的字符串
     * @return
     * @throws Exception
     */

    public static byte[] decrypt(byte[] content)
    {
        try
        {
            SecretKeySpec secretKeySpec = new SecretKeySpec(DEFULT_PASSWORD.getBytes(),
                    TRANSFORMATION);
            Cipher cipher=Cipher.getInstance(MODE);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec,new IvParameterSpec(IV));
            // 解密
            return cipher.doFinal(content);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 将二进制转16进制字符串
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte[] buf)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }


    /**
     * 将16进制转换为二进制
     *
     * @param
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) throws Exception
    {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < result.length; i++) {
            int high = Integer.parseInt(hexStr.substring(2 * i, 2 * i + 1), 16);
            int low = Integer.parseInt(hexStr.substring(2 * i + 1, 2 * i + 2), 16);
            result[i] = (byte)(high * 16 + low);
        }
        return result;
    }



    public static String padRight(String self, Number numberOfChars) {
        return padRight((CharSequence)self, numberOfChars, (CharSequence)" ");
    }
    public static String padRight(CharSequence self, Number numberOfChars, CharSequence padding) {
        int numChars = numberOfChars.intValue();
        return numChars <= self.length() ? self.toString() : self + getPadding(padding.toString(), numChars - self.length());
    }
    private static String getPadding(CharSequence padding, int length) {
        return padding.length() < length ? multiply((CharSequence)padding, length / padding.length() + 1).substring(0, length) : "" + padding.subSequence(0, length);
    }
}
