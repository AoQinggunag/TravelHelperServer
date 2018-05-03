package com.xiaomo.travelhelper.pojo;

import java.util.Date;

public class ChatGroup {
    private Integer id;

    private Integer sum;

    private Date createTime;

    private Date updateTime;

    public ChatGroup(Integer id, Integer sum, Date createTime, Date updateTime) {
        this.id = id;
        this.sum = sum;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ChatGroup() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}