package com.xiaomo.travelhelper.service;

import com.xiaomo.netty4chat.common.core.annotation.InactiveHandler;
import com.xiaomo.netty4chat.common.core.annotation.MoCmd;
import com.xiaomo.netty4chat.common.core.annotation.MoConfig;
import com.xiaomo.netty4chat.common.core.annotation.MoModule;
import com.xiaomo.netty4chat.common.core.start.RequestHandler;
import com.xiaomo.netty4chat.common.core.start.ResponseHandler;
import com.xiaomo.travelhelper.commons.ResultMessage;

/**
 * author: mojiale66@163.com
 * date:   2018/4/28
 * description: 聊天服务接口
 */
@MoModule(module = 1)
@MoConfig
public interface IChatService {

    @MoCmd(cmd = 1)
    void privateChat(RequestHandler requestHandler, ResponseHandler responseHandler);

    @MoCmd(cmd = 2)
    void publicChat(RequestHandler requestHandler, ResponseHandler responseHandler);

    @MoCmd(cmd = 3)
    void online(RequestHandler requestHandler, ResponseHandler responseHandler);

    @InactiveHandler
    void inActive(RequestHandler requestHandler, ResponseHandler responseHandler);

    ResultMessage listAndDeleteByTargetAccount(String targetAccount);

}
