package com.xiaomo.travelhelper.commons;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * 响应报文
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResultMessage implements Serializable{

    private int status;
    private String msg;
    private Object data;

    private ResultMessage(){}

    private ResultMessage(int status){
        this.status = status;
    }

    private ResultMessage(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    private ResultMessage(int status,String msg,Object data){

        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static ResultMessage buildBySuccess(){
        return new ResultMessage(ResultCode.SUCCESS.getStatus());
    }

    public static ResultMessage buildBySuccess(String msg){
        return new ResultMessage(ResultCode.SUCCESS.getStatus(),msg);
    }

    public static ResultMessage buildBySuccess(String msg,Object data){
        return new ResultMessage(ResultCode.SUCCESS.getStatus(),msg,data);
    }

    public static ResultMessage buildByFail(){
        return new ResultMessage(ResultCode.FAIL.getStatus());
    }

    public static ResultMessage buildByFail(String msg){
        return new ResultMessage(ResultCode.FAIL.getStatus(),msg);
    }

    public static ResultMessage buildByFail(String msg,Object data){
        return new ResultMessage(ResultCode.FAIL.getStatus(),msg,data);
    }

    public boolean isSuccess(){
        return this.status == ResultCode.SUCCESS.getStatus();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultMessage{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
