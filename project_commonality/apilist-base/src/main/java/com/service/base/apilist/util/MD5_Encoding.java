package com.service.base.apilist.util;

import org.apache.commons.codec.binary.Hex;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

/**
 * @Description: md5加密
 * @Author: lgw
 * @Date: 2020/06/22
 */
public class MD5_Encoding {
    /**
       * 对字符串md5加密(小写+数字)
       *
       * @param str 传入要加密的字符串
       * @return  MD5加密后的字符串
       */
     public static String lowerMD5(String str) {
         try {
                 // 生成一个MD5加密计算摘要
                 MessageDigest md = MessageDigest.getInstance("MD5");
                 // 计算md5函数
                 md.update(str.getBytes());
                 // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
                 // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
                 return new BigInteger(1, md.digest()).toString(16);
             } catch (Exception e) {
                e.printStackTrace();
                return null;
             }
     }

    /**
    * 对字符串md5加密(大写+数字)
    *
    * @param s 传入要加密的字符串
    * @return  MD5加密后的字符串
    */
     public static String upperMD5(String s) {
         char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
         try {
                 byte[] btInput = s.getBytes();
                 // 获得MD5摘要算法的 MessageDigest 对象
                 MessageDigest mdInst = MessageDigest.getInstance("MD5");
                 // 使用指定的字节更新摘要
                 mdInst.update(btInput);
                 // 获得密文
                 byte[] md = mdInst.digest();
                 // 把密文转换成十六进制的字符串形式
                 int j = md.length;
                 char str[] = new char[j * 2];
                 int k = 0;
                 for (int i = 0; i < j; i++) {
                         byte byte0 = md[i];
                         str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                         str[k++] = hexDigits[byte0 & 0xf];
                     }
                 return new String(str);
             } catch (Exception e) {
                 e.printStackTrace();
                 return null;
             }
     }

    /**
     * 生成含有随机盐的密码
     */
    public static String generate(String password) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        //随机加盐
        /*sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));*/
        sb.append("01234md5encoding");
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 校验密码是否正确
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // 加密+加盐
        String password1 = generate("admin");
        System.out.println("结果：" + password1 + "   长度："+ password1.length());
        // 解码
        System.out.println(verify("admin", password1));
        // 加密+加盐
        String password2= generate("admin");
        System.out.println("结果：" + password2 + "   长度："+ password2.length());
        // 解码
        System.out.println(verify("admin", password2));
    }
}
