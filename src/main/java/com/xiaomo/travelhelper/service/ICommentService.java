package com.xiaomo.travelhelper.service;


import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.pojo.Comment;

/**
 * 评论服务类接口
 */

public interface ICommentService {

    ResultMessage save(Comment comment);



}

