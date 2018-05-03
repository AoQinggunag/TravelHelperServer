package com.xiaomo.travelhelper.service;

import com.xiaomo.travelhelper.commons.ResultMessage;

/**
 * 朋友接口服务类
 */
public interface IFriendService {

    ResultMessage listFriends(String account);

    ResultMessage likeByAccountOrUsername(String val);

    ResultMessage addFriend(String myAccount,String targetAccount,String desc);

    ResultMessage agreeFriend(String myAccount,String targetAccount);




}
