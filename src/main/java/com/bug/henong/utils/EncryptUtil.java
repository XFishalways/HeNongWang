package com.bug.henong.utils;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;

public class EncryptUtil {

    //构造
    private static Digester digester = DigestUtil.digester("sm3");

    //返回Hash值
    public static String getDigestHex(String password, String salt) {

        String digestHex_1 = digester.digestHex(password);

        String digestHex_2 = digester.digestHex(digestHex_1 + salt);

        return digestHex_2;
    }
}
