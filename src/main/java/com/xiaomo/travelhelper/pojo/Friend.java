package com.xiaomo.travelhelper.pojo;

import java.util.Date;

public class Friend {
    private String userAccount1;

    private String userAccount2;

    private Date createTime;

    public Friend(String userAccount1, String userAccount2, Date createTime) {
        this.userAccount1 = userAccount1;
        this.userAccount2 = userAccount2;
        this.createTime = createTime;
    }

    public Friend() {
        super();
    }

    public String getUserAccount1() {
        return userAccount1;
    }

    public void setUserAccount1(String userAccount1) {
        this.userAccount1 = userAccount1 == null ? null : userAccount1.trim();
    }

    public String getUserAccount2() {
        return userAccount2;
    }

    public void setUserAccount2(String userAccount2) {
        this.userAccount2 = userAccount2 == null ? null : userAccount2.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}