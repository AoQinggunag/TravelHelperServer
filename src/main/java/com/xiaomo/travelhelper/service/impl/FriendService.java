package com.xiaomo.travelhelper.service.impl;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.commons.SystemConst;
import com.xiaomo.travelhelper.mapper.FriendMapper;
import com.xiaomo.travelhelper.mapper.MsgQueueMapper;
import com.xiaomo.travelhelper.mapper.UserMapper;
import com.xiaomo.travelhelper.pojo.Friend;
import com.xiaomo.travelhelper.pojo.MsgQueue;
import com.xiaomo.travelhelper.pojo.dto.FriendInfo;
import com.xiaomo.travelhelper.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * 朋友服务实现类
 */
@Service("friendService")
public class FriendService implements IFriendService{

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private MsgQueueMapper msgQueueMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultMessage listFriends(String account) {

        List<FriendInfo> resultList = friendMapper.listFriends(account);
        return ResultMessage.buildBySuccess("获取成功",resultList);
    }

    @Override
    public ResultMessage likeByAccountOrUsername(String val) {
        if(StringUtils.isEmpty(val)){
            return ResultMessage.buildBySuccess("获取成功", Collections.emptyList());
        }
        List<FriendInfo> resultList = friendMapper.likeByAccountOrUsername("%"+val+"%","%"+val+"%");
        return ResultMessage.buildBySuccess("获取成功",resultList);
    }

    @Override
    @Transactional
    public ResultMessage addFriend(String myAccount, String targetAccount,String desc) {

        int resultMyAccount = userMapper.checkAccount(myAccount);
        int resultTargetAccount = userMapper.checkAccount(targetAccount);
        if(resultMyAccount != 1 && resultTargetAccount != 1){
            return ResultMessage.buildByFail("参数异常");
        }
        if(myAccount.equals(targetAccount)){
            return ResultMessage.buildByFail("不能添加自己为朋友");
        }

        int resultPk = friendMapper.checkPK(myAccount,targetAccount);
        if(resultPk > 0){
            return ResultMessage.buildByFail("该用户已经是你的朋友");
        }

        MsgQueue msgQueue = new MsgQueue();
        msgQueue.setAccount(targetAccount);
        msgQueue.setVal(myAccount);
        msgQueue.setType(SystemConst.MSG_TYPE_FRIEND);
        msgQueue.setDescription(desc);

        int result =  msgQueueMapper.insertSelective(msgQueue);
        if(result > 0){
            return ResultMessage.buildBySuccess("消息发送成功");
        }
        return ResultMessage.buildByFail("消息发送失败");
    }

    @Override
    @Transactional
    public ResultMessage agreeFriend(String myAccount, String targetAccount) {

        int resultMyAccount = userMapper.checkAccount(myAccount);
        int resultTargetAccount = userMapper.checkAccount(targetAccount);
        if(resultMyAccount != 1 && resultTargetAccount != 1){
            return ResultMessage.buildByFail("参数异常");
        }

        Friend friend = new Friend();
        friend.setUserAccount1(myAccount);
        friend.setUserAccount2(targetAccount);
        try{
            friendMapper.insertSelective(friend);
            msgQueueMapper.deleteByMsgFriend(myAccount,targetAccount);
        }catch (Exception e){
            throw new RuntimeException("该用户已经是你的朋友");
        }
        return ResultMessage.buildBySuccess("添加新朋友成功");
    }
}
