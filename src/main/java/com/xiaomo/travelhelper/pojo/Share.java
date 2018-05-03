package com.xiaomo.travelhelper.pojo;

import java.util.Date;

public class Share {
    private Integer id;

    private String account;

    private String content;

    private String imgUrl;

    private Date createTime;

    public Share(Integer id, String account, String content, String imgUrl, Date createTime) {
        this.id = id;
        this.account = account;
        this.content = content;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
    }

    public Share() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}