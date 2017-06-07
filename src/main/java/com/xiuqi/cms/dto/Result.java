package com.xiuqi.cms.dto;

/**
 * Created by frank on 2017/5/27.
 */
public class Result {

    private String code;//返回状态码

    private String msg;//返回信息

    private Object data;//接口返回数据

    public Result() {
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
