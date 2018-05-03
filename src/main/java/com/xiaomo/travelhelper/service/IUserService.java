package com.xiaomo.travelhelper.service;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.pojo.User;

/**
 * 用户服务类接口
 */
public interface IUserService {

    ResultMessage registerUser(User user);

    ResultMessage login(String account,String password);

    ResultMessage logout(String account);

    ResultMessage updateUser(User user);

    ResultMessage updatePassword(String account,String oldPassword,String newPassword);

    ResultMessage getUserInfo(String account);

    ResultMessage isOnLine(String account);


}
