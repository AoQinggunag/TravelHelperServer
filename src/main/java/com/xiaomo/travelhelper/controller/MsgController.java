package com.xiaomo.travelhelper.controller;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.service.IMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息控制器
 */
@RestController
@RequestMapping("/api/msg")
public class MsgController {

    @Autowired
    private IMsgService msgService;

    @PostMapping("/listMsgFriend")
    public ResultMessage listMsgFriend(String account){

        return msgService.listMsgFriend(account);

    }






}
