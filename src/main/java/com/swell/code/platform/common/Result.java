package com.swell.code.platform.common;

public class Result {

    public static class ErrorCodes {
        public static String PASSWORD_ERROR = "9999";
    }

    private String code;
    private String msg;
    private Object data;

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

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result success() {
        return new Result("0000", "success");
    }

    public static Result success(String msg) {
        Result result = success();
        result.setMsg(msg);
        return result;
    }

    public static Result error() {
        return new Result("0001", "error");
    }

    public static Result error(String msg) {
        Result result = error();
        result.setMsg(msg);
        return result;
    }

    public static Result error(String code, String msg) {
        Result result = error();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public Result addData(Object data) {
        this.setData(data);
        return this;
    }
}
