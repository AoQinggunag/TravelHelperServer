package com.xiaomo.travelhelper.service.impl;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.commons.SystemConst;
import com.xiaomo.travelhelper.mapper.MsgQueueMapper;
import com.xiaomo.travelhelper.pojo.dto.FriendInfo;
import com.xiaomo.travelhelper.service.IMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消息服务类
 */
@Service("msgService")
public class MsgService implements IMsgService {

    @Autowired
    private MsgQueueMapper msgQueueMapper;


    @Override
    public ResultMessage listMsgFriend(String account) {

        List<FriendInfo> resultList = msgQueueMapper.getMsgFriendByAccount(account, SystemConst.MSG_TYPE_FRIEND);
        return ResultMessage.buildBySuccess("获取成功",resultList);
}
}
