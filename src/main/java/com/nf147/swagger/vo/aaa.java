package com.nf147.swagger.vo;

public class aaa {
    private int code;
    private String type;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public aaa(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.msg = message;
    }

    public aaa() {
    }

    public aaa(String type, String message) {
        this.type = type;
        this.msg = message;
    }

}
