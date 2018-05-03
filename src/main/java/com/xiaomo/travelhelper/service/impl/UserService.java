package com.xiaomo.travelhelper.service.impl;

import com.xiaomo.travelhelper.commons.RedisClient;
import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.mapper.UserMapper;
import com.xiaomo.travelhelper.pojo.User;
import com.xiaomo.travelhelper.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 用户服务类实现类
 */
@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisClient redisClient;

    @Override
    @Transactional
    public ResultMessage registerUser(User user) {

       ResultMessage resultMessage = checkParams(user,true);
       if(resultMessage.isSuccess()){
           // 注册默认昵称为账号
           user.setUsername(user.getAccount());
           int result = userMapper.insertSelective(user);
           if(result > 0 ){
               return ResultMessage.buildBySuccess("注册成功",user);
           }
       }
       return resultMessage;
    }

    @Override
    public ResultMessage login(String account, String password) {
        User user = userMapper.checkLogin(account,password);
        if(user != null){
            // 缓存处理
            String token = UUID.randomUUID().toString();
            redisClient.add(account,token);
            return ResultMessage.buildBySuccess("登录成功",token);
        }
        return ResultMessage.buildByFail("账号或密码错误");
    }

    @Override
    public ResultMessage logout(String account) {
        redisClient.remove(account);
        return ResultMessage.buildBySuccess("退出成功");
    }

    @Override
    @Transactional
    public ResultMessage updateUser(User user) {

        ResultMessage resultMessage = checkParams(user,false);
        if(resultMessage.isSuccess()){
            int result = userMapper.updateByAccountSelective(user);
            if(result > 0){
                return ResultMessage.buildBySuccess("更改成功",userMapper.findByAccount(user.getAccount()));
            }else{
                return ResultMessage.buildByFail("更改失败");
            }
        }
        return resultMessage;
    }

    @Override
    @Transactional
    public ResultMessage updatePassword(String account,String oldPassword,String newPassword) {

        User result = userMapper.checkLogin(account,oldPassword);
        if(result == null){
            return ResultMessage.buildByFail("密码错误");
        }
        User user = new User();
        user.setAccount(account);
        user.setPassword(newPassword);
        return updateUser(user);
    }

    @Override
    public ResultMessage getUserInfo(String account) {
        User user = userMapper.findByAccount(account);
        if(user == null){
            return ResultMessage.buildByFail("用户不存在");
        }
        return ResultMessage.buildBySuccess("获取成功",user);
    }

    @Override
    public ResultMessage isOnLine(String account) {
        if(redisClient.isHasKey(account)){
            return ResultMessage.buildBySuccess("用户在线");
        }
        return ResultMessage.buildByFail("用户不在线");
    }

    private ResultMessage checkParams(User user,boolean checkAccount){

        String account = user.getAccount();
        String email = user.getEmail();
        String img = user.getImg();
        if(!StringUtils.isEmpty(account)){
            int accountNum = userMapper.checkAccount(account);
            if(checkAccount && accountNum > 0){
                    return ResultMessage.buildByFail("该账号已存在");
            }else if(!checkAccount && accountNum <= 0){
                    return ResultMessage.buildByFail("该账号不存在");
            }
        }
        if(!StringUtils.isEmpty(email)){
            if(userMapper.checkEmail(email) > 0 ){
                return ResultMessage.buildByFail("该邮箱已被使用");
            }
        }
        if(!StringUtils.isEmpty(img)){
            if(userMapper.checkImg(img) > 0 ){
                return ResultMessage.buildByFail("该手机已被使用");
            }
        }

        return ResultMessage.buildBySuccess();
    }


}
