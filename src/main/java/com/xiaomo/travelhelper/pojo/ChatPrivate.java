package com.xiaomo.travelhelper.pojo;

import java.util.Date;

public class ChatPrivate {
    private Integer id;

    private String targetUserId;

    private String sendUserId;

    private String content;

    private Date createTime;

    public ChatPrivate(Integer id, String targetUserId, String sendUserId, String content, Date createTime) {
        this.id = id;
        this.targetUserId = targetUserId;
        this.sendUserId = sendUserId;
        this.content = content;
        this.createTime = createTime;
    }

    public ChatPrivate() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId == null ? null : targetUserId.trim();
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId == null ? null : sendUserId.trim();
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