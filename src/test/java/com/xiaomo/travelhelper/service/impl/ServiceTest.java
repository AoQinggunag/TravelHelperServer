package com.xiaomo.travelhelper.service.impl;

import com.xiaomo.travelhelper.TravelHelperServerApplication;
import com.xiaomo.travelhelper.commons.RedisClient;
import com.xiaomo.travelhelper.pojo.User;
import com.xiaomo.travelhelper.service.IFriendService;
import com.xiaomo.travelhelper.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TravelHelperServerApplication.class)
public class ServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private IFriendService friendService;

    @Autowired
    private RedisClient redisClient;

    @Test
    public void redisClientTest(){

        //redisClient.add("momo","66666");
        System.out.println(redisClient.get("momo"));
        System.out.println(redisClient.isHasKey("momo"));
        System.out.println(redisClient.getExpire("momo"));

    }

    @Test
    public void listFriend(){

        System.out.println(friendService.listFriends("13113288564"));


    }




}