package com.wuliu.utils;

public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result() {
    }

    //封装静态方法  -- 成功！--无数据返回
    public static <T> Result<T> success(String message) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMessage(message);
        return result;
    }

    //封装静态方法  -- 成功！--有数据返回
    public static <T> Result<T> success(T data, String message) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    //封装静态方法  -- 失败
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setCode(-1);
        result.setMessage(message);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
