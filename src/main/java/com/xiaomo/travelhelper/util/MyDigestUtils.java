package com.xiaomo.travelhelper.util;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * 加密工具类
 */
public class MyDigestUtils {

    public static String md5DigestAsHex(byte[] bytes){
        if(bytes == null){
            return null;
        }
        return DigestUtils.md5DigestAsHex(bytes);
    }

    public static String md5DigestAsHex(String content){
        if(StringUtils.isEmpty(content)){
            return null;
        }
        return DigestUtils.md5DigestAsHex(content.getBytes());
    }
}
