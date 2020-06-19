package com.web.exception;


import com.service.base.apilist.enums.JsonReturnCodeEnum;

/**
 * 通用异常处理，
 */
public class GlobalRequestException extends RuntimeException {
    private JsonReturnCodeEnum code;
    private boolean printLog = true;

    public GlobalRequestException(String message, JsonReturnCodeEnum code) {
        super(message);
        this.code = code;
    }

    public GlobalRequestException(String message, JsonReturnCodeEnum code, boolean printLog) {
        super(message);
        this.code = code;
        this.printLog = printLog;
    }

    public GlobalRequestException(JsonReturnCodeEnum code, boolean printLog) {
        super("");
        this.code = code;
        this.printLog = printLog;
    }


    public boolean isPrintLog() {
        return printLog;
    }

    public JsonReturnCodeEnum getCode() {
        return code;
    }
}
