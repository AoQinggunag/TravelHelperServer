package com.xiaomo.travelhelper.commons;

import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * author: mojiale66@163.com
 * date:   2018/4/28
 * description: Netty 映射描述
 */
public class NettyMappingDesc {

    public static Map<Short,String> moduleMap;
    public static Map<Short,String> cmdMap;

    static {
        moduleMap = Maps.newHashMap();
        cmdMap = Maps.newHashMap();

        moduleMap.put((short)1,"聊天模块");

        cmdMap.put((short)1,"私聊");
        cmdMap.put((short)2,"公聊");
        cmdMap.put((short)3,"上线");


    }

    public static String getByModule(short flag){
        String desc =  moduleMap.get(flag);
        if(StringUtils.isEmpty(desc)){
            desc = "不明模块";
        }
        return desc;
    }

    public static String getByCmd(short flag){
        String desc =  cmdMap.get(flag);
        if(StringUtils.isEmpty(desc)){
            desc = "不明指令";
        }
        return desc;
    }





}
