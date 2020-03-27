package com.logistics.manage.entity;

/**
 * @Create 2020-03-03 17:09
 */
public class ReturnResult {
    private Integer code;
    private String msg;

    public ReturnResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
