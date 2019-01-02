package com.px.test.pdd.excption;


/**
 * @description:
 * @author: suding
 * @create: 2018-06-09 11:10
 **/
public class BaseException extends RuntimeException {

    private int errorCode = 0;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(ErrorCode errorCode) {
         super(errorCode.getErrorMsg());
         this.setErrorCode(errorCode.getErrorCode());
    }

    public BaseException(int errorCode, String message) {
        super(message);
        this.setErrorCode(errorCode);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
