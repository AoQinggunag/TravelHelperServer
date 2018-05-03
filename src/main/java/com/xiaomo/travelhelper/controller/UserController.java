package com.xiaomo.travelhelper.controller;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.pojo.User;
import com.xiaomo.travelhelper.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResultMessage login(String account,String password){

        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
            return ResultMessage.buildByFail("账号和密码不能为空");
        }
        return userService.login(account,password);

    }

    @PostMapping("/logout")
    public ResultMessage logout(String account){

        if(StringUtils.isEmpty(account)){
            return ResultMessage.buildByFail("账号不能为空");
        }
        return userService.logout(account);

    }

    @PostMapping("/register")
    public ResultMessage register(User user){

        String account = user.getAccount();
        String password = user.getPassword();
        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
            return ResultMessage.buildByFail("账号和密码不能为空");
        }
        user.setId(null);
        ResultMessage resultMessage = userService.registerUser(user);
        return resultMessage;
    }

    @PostMapping("/update")
    public ResultMessage update(User user){

        String account = user.getAccount();
        if(StringUtils.isEmpty(account)){
            return ResultMessage.buildByFail("账号不能为空");
        }
        return userService.updateUser(user);
    }

    @PostMapping("/getInfo")
    public ResultMessage getUserInfo(String account){
        if(StringUtils.isEmpty(account)){
            return ResultMessage.buildByFail("账号不能为空");
        }
        return userService.getUserInfo(account);
    }

    @PostMapping("/isOnLine")
    public ResultMessage isOnLine(String account){
        if(StringUtils.isEmpty(account)){
            return ResultMessage.buildByFail("账号不能为空");
        }
        return userService.isOnLine(account);
    }

    @PostMapping("/updatePsw")
    public ResultMessage updatePassword(String account,String oldPassword,String newPassword){

        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)){
            return ResultMessage.buildByFail("原密码或新密码不能为空");
        }
        return userService.updatePassword(account,oldPassword,newPassword);
    }

}
