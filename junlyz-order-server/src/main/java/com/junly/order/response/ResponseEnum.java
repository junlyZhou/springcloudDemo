package com.junly.order.response;

/**
 * @ClassName ResponseEnum
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/16 0016 16:05
 * @Version 1.0
 **/
public enum  ResponseEnum {
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    ;

    private Integer code;
    private String msg;

    private ResponseEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
