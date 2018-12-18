package com.junly.order.response;

/**
 * @ClassName Response
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/16 0016 16:04
 * @Version 1.0
 **/
public class Response<T> {

    private Integer code = 0;

    private String msg = "成功";

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
