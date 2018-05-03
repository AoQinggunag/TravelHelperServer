package com.xiaomo.travelhelper.pojo;

import java.util.Date;

public class Comment {
    private Integer id;

    private Integer shareId;

    private String commentorId;

    private String content;

    private Date createTime;

    public Comment(Integer id, Integer shareId, String commentorId, String content, Date createTime) {
        this.id = id;
        this.shareId = shareId;
        this.commentorId = commentorId;
        this.content = content;
        this.createTime = createTime;
    }

    public Comment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

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
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}