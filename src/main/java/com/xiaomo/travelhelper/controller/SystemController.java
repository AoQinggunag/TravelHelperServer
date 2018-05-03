package com.xiaomo.travelhelper.controller;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.service.ISysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统控制器
 */
@RestController
@RequestMapping("/api/sys")
public class SystemController {

    @Autowired
    private ISysService sysService;

    @GetMapping("/sum")
    public ResultMessage getSumData(){

        return sysService.getSumData();

    }

    @GetMapping("/comment")
    public ResultMessage getCommentData(){

        return sysService.getCommentData();

    }

    @GetMapping("/share")
    public ResultMessage getShareData(){

        return sysService.getShareData();

    }

    @GetMapping("/user")
    public ResultMessage getUserData(){

        return sysService.getUserData();

    }


}
