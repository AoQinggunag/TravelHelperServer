package com.xiaomo.travelhelper.controller;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: mojiale66@163.com
 * date:   2018/4/29
 * description:
 */
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private IChatService chatService;

    @PostMapping("/list")
    public ResultMessage listAndDeleteChat(String account){

        return chatService.listAndDeleteByTargetAccount(account);

    }

}
