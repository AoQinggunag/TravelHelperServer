package com.xiaomo.travelhelper.service.impl;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.mapper.CommentMapper;
import com.xiaomo.travelhelper.pojo.Comment;
import com.xiaomo.travelhelper.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 评论服务类
 */
@Service("commentService")
public class CommentService implements ICommentService{

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public ResultMessage save(Comment comment) {

        int result = commentMapper.insertSelective(comment);
        if(result > 0){
            return ResultMessage.buildBySuccess("发送成功");
        }
        return ResultMessage.buildByFail("发送失败");
    }
}

