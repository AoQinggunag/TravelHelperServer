package com.xiaomo.travelhelper.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis 客户端,默认缓存 60 分钟
 */
@Component
public class RedisClient {

    private final long REDIS_TIME_OUT = 60 * 60;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void add(String key,String val){
        redisTemplate.opsForValue().set(key,val,REDIS_TIME_OUT,TimeUnit.SECONDS);
    }

    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public boolean isHasKey(String key){
        return redisTemplate.hasKey(key);
    }

    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    public boolean remove(String key){
        return redisTemplate.delete(key);
    }



}
