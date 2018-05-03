package com.xiaomo.travelhelper.pojo;

public class MsgQueue {
    private Integer id;

    private String account;

    private Integer type;

    private String val;

    private String description;

    public MsgQueue(Integer id, String account, Integer type, String val, String description) {
        this.id = id;
        this.account = account;
        this.type = type;
        this.val = val;
        this.description = description;
    }

    public MsgQueue() {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}