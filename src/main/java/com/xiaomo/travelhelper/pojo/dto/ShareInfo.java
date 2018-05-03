package com.xiaomo.travelhelper.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 分享信息
 */
public class ShareInfo {
    private Integer id;

    private String account;

    private String content;

    private String imgUrl;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date createTime;

    private String username;

    private String img;

    private String area;

    private List<CommentInfo> commentList;

    public ShareInfo() {
    }

    public ShareInfo(Integer id, String account, String content, String imgUrl, Date createTime, String username, String img, String area) {
        this.id = id;
        this.account = account;
        this.content = content;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.username = username;
        this.img = img;
        this.area = area;
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
        this.account = account;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<CommentInfo> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentInfo> commentList) {
        this.commentList = commentList;
    }
}
