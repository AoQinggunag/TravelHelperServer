package com.xiaomo.travelhelper.pojo.dto;

/**
 * 朋友信息
 */
public class FriendInfo {

    private Integer id;

    private String username;

    private String account;

    private String email;

    private String img;

    private String area;

    private String description;

    public FriendInfo() {
    }

    public FriendInfo(Integer id, String username, String account, String email, String img, String area) {
        this.id = id;
        this.username = username;
        this.account = account;
        this.email = email;
        this.img = img;
        this.area = area;
    }

    public FriendInfo(Integer id, String username, String account, String email, String img, String area,String description) {
        this.id = id;
        this.username = username;
        this.account = account;
        this.email = email;
        this.img = img;
        this.area = area;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FriendInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", img='" + img + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
