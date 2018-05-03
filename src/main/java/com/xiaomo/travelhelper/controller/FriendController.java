package com.xiaomo.travelhelper.controller;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 朋友控制器
 */
@RestController
@RequestMapping("/api/friend")
public class FriendController {

    @Autowired
    private IFriendService friendService;

    @PostMapping("/list")
    public ResultMessage listFriends(String account){

        return friendService.listFriends(account);
    }


    @PostMapping("/likeByAccountOrUsername")
    public ResultMessage likeByAccountOrUsername(String val){

        return friendService.likeByAccountOrUsername(val);
    }

    @PostMapping("/addFriend")
    public ResultMessage addFriend(String account,String targetAccount,String desc){

        return friendService.addFriend(account,targetAccount,desc);
    }

    @PostMapping("/agreeFriend")
    public ResultMessage agreeFriend(String account,String targetAccount){

        return friendService.agreeFriend(account,targetAccount);
    }



}
