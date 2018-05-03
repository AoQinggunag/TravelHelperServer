package com.xiaomo.travelhelper.commons;

/**
 * 响应结果码
 */
public enum  ResultCode {

    SUCCESS(1,"SUCCESS"),
    FAIL(2,"FAIL");

    private final int status;
    private final String desc;

    ResultCode(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

}
