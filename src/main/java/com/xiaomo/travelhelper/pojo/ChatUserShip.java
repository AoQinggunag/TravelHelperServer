package com.xiaomo.travelhelper.pojo;

import java.util.Date;

public class ChatUserShip {
    private String userId;

    private Integer chatGroupId;

    private Date createTime;

    public ChatUserShip(String userId, Integer chatGroupId, Date createTime) {
        this.userId = userId;
        this.chatGroupId = chatGroupId;
        this.createTime = createTime;
    }

    public ChatUserShip() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getChatGroupId() {
        return chatGroupId;
    }

    public void setChatGroupId(Integer chatGroupId) {
        this.chatGroupId = chatGroupId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}