package com.service.base.apilist;

import java.io.Serializable;

/**
 * @Description: 请求结果返回
 * @Author: lgw
 * @Date: 2020/06/16
 */
public class RequestResult<T> implements Serializable {
    private boolean success = true;
    private T body;
    private String errMessage;

    public RequestResult() {

    }

    public RequestResult(T body) {
        this.body = body;
    }

    public RequestResult(boolean success, T body) {
        this.success = success;
        this.body = body;
    }

    public RequestResult(boolean success, T body, String errMessage) {
        this.success = success;
        this.body = body;
        this.errMessage = errMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T pickBody() {
        if(!success){
            throw new RequestResultException(errMessage);
        }
        return body;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
