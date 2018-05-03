package com.xiaomo.travelhelper.service.impl;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.mapper.CommentMapper;
import com.xiaomo.travelhelper.mapper.ShareMapper;
import com.xiaomo.travelhelper.mapper.UserMapper;
import com.xiaomo.travelhelper.service.ISysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 系统服务类
 */
@Service("sysService")
public class SysService implements ISysService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShareMapper shareMapper;
    @Autowired
    private CommentMapper commentMapper;


    @Override
    public ResultMessage getSumData() {

        int userNum = userMapper.countOfUser();
        int shareNum = shareMapper.countOfShare();
        int commentNum = commentMapper.countOfComment();

        List<Integer> data = new ArrayList<>();
        data.add(userNum);
        data.add(shareNum);
        data.add(commentNum);

        return ResultMessage.buildBySuccess("获取成功",data);
    }

    @Override
    public ResultMessage getUserData() {

        List<Map<String,Object>> result = userMapper.listUserDataGroupByMonth();
        return ResultMessage.buildBySuccess("获取成功",listMapToList(result));
    }



    @Override
    public ResultMessage getCommentData() {
        List<Map<String,Object>> result = commentMapper.listCommentDataGroupByMonth();
        return ResultMessage.buildBySuccess("获取成功",listMapToList(result));
    }

    @Override
    public ResultMessage getShareData() {
        List<Map<String,Object>> result = shareMapper.listShareDataGroupMonth();
        return ResultMessage.buildBySuccess("获取成功"
                ,listMapToList(result));
    }

    private List<Long> listMapToList(List<Map<String,Object>> result){
        List<Long> data = new ArrayList<>();
        for(int i=0;i<12;i++){
            data.add(0L);
        }
        for(Map<String,Object> map : result){
            System.out.println(map.get("countNum") + ":" + map.get("createMonth"));
            Long num = (Long) map.get("countNum");
            Integer month = (Integer) map.get("createMonth");
            data.set((int)month-1,num);
        }
        return data;
    }


}
