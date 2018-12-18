package com.junly.response;

/**
 * @ClassName ResultVo
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/16 0016 14:37
 * @Version 1.0
 **/
public class ResultVo<T> {
    /**
     * @description 状态码 0:成功 ; 1：失败
     * @author junly
     * @date 2018/12/16
     */
    private Integer code = 0;
    /**
     * @description 消息
     * @author junly
     * @date 2018/12/16
     */
    private String msg = "成功";
    /**
     * @description 响应数据
     * @author junly
     * @date 2018/12/16
     */
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
