package com.xiaomo.travelhelper.controller;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.pojo.Comment;
import com.xiaomo.travelhelper.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息控制器
 */
@RestController
@RequestMapping("/api/share")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping("/comment")
    public ResultMessage comment(Comment comment){
        return commentService.save(comment);

    }

}
