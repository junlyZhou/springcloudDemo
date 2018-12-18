package com.junly.enume;

/**
 * @ClassName ResponseEnume
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/16 0016 15:04
 * @Version 1.0
 **/
public enum  ResponseEnume {
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    ;
    private ResponseEnume(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
