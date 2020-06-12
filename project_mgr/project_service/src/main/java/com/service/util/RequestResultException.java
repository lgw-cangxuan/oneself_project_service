package com.service.util;

/**
 * Created by yoara on 2017/12/19.
 */
public class RequestResultException extends RuntimeException {
    String code;
    public RequestResultException(String message) {
        super(message);
    }
    public RequestResultException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}