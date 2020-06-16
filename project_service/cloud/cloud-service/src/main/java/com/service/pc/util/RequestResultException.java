package com.service.pc.util;

/**
 * RequestResultException class
 * 请求结果异常
 * @author lgw
 * @date 2020/06/16
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