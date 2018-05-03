package com.xiaomo.travelhelper.pojo.dto;

/**
 * 评论
 */
public class CommentInfo {

    private String commentorId;

    private String content;

    private String username;

    public String getCommentorId() {
        return commentorId;
    }

    public void setCommentorId(String commentorId) {
        this.commentorId = commentorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CommentInfo(String commentorId, String content, String username) {
        this.commentorId = commentorId;
        this.content = content;
        this.username = username;
    }
}
