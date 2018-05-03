package com.xiaomo.netty4chat.common.core.annotation;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * author: mojiale66@163.com
 * date:   2018/4/28
 * description: Invoker 对象集合
 */
@Component
public class InvokerHolder {

    private static Map<Short,Map<Short,Invoker>> invokerMap = Maps.newConcurrentMap();

    private static Map<String,Invoker> configMap = Maps.newConcurrentMap();

    public static void putInvoker(short module,short cmd,Invoker invoker){

        Map<Short, Invoker> moduleMap = invokerMap.get(module);
        if(moduleMap == null){
            moduleMap = Maps.newHashMap();
            moduleMap.put(cmd, invoker);
            invokerMap.put(module, moduleMap);
            return;
        }

        if(moduleMap.get(cmd) == null){
            moduleMap.put(cmd,invoker);
        }
    }

    public static Invoker getInvoker(short module,short cmd){

        Map<Short, Invoker> moduleMap = invokerMap.get(module);
        if(moduleMap != null){
            return moduleMap.get(cmd);
        }

        return null;
    }

    public static void putConfigInvoker(String key,Invoker invoker){

        configMap.put(key,invoker);
    }

    public static Invoker getConfigInvoker(String key){

        return configMap.get(key);
    }

}
