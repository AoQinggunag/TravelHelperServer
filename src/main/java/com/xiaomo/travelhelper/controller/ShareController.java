package com.xiaomo.travelhelper.controller;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.pojo.Share;
import com.xiaomo.travelhelper.service.IShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分享控制器
 */
@RestController
@RequestMapping("/api/share")
public class ShareController {

    @Autowired
    private IShareService shareService;

    @PostMapping("/send")
    public ResultMessage send(Share share){
        return shareService.saveShare(share);

    }

    @PostMapping("/list")
    public ResultMessage listShares(){
        return shareService.listShares();
    }

    @PostMapping("/listByPage")
    public ResultMessage listSharesByPage(Integer pageNo,Integer pageSize){
        if(pageNo == null){
            pageNo = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        return shareService.listSharesByPage(pageSize,pageNo);
    }

}
