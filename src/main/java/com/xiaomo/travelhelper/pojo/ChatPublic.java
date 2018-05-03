package com.xiaomo.travelhelper.pojo;

import java.util.Date;

public class ChatPublic {
    private Integer id;

    private Integer chatGroupId;

    private String userId;

    private String content;

    private Date createTime;

    public ChatPublic(Integer id, Integer chatGroupId, String userId, String content, Date createTime) {
        this.id = id;
        this.chatGroupId = chatGroupId;
        this.userId = userId;
        this.content = content;
        this.createTime = createTime;
    }

    public ChatPublic() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChatGroupId() {
        return chatGroupId;
    }

    public void setChatGroupId(Integer chatGroupId) {
        this.chatGroupId = chatGroupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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