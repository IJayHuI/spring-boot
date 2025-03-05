//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.springboot;

public class Response<T> {
    private T data;
    private boolean success;
    private String errorMsg;

    public Response() {
    }

    public static <K> Response<K> newSuccess(K data) {
        Response<K> response = new Response<K>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static Response<Void> newError(String errorMsg) {
        Response<Void> response = new Response<Void>();
        response.setErrorMsg(errorMsg);
        response.setSuccess(false);
        return response;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
