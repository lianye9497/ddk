package com.px.test.pdd.excption;

/**
 * @description:
 * @author: suding
 * @create: 2018-06-09 11:11
 **/
public enum ErrorCode {
    PARAMS_REQUIRED(1001, "必填参数不能为空"),
    SYSTEM_ERROR(1004,"系统异常"),
    APPLY_ORDER_LOCK_ERROR(2001,"申请失败,服务器繁忙"),
    APPLY_UPPER_LIMIT_NUMBER(2003,"人数上限"),

    NOT_LOGIN(20001,"用户未登陆"),
    NOT_COMPLETE_USER_INFO(20002,"用户未完善信息"),
    Y_ICON_NOT_ENOUGH(20003,"亲，目前您的Y币不足哦！"),
    NOT_USE_Y_COIN_QUALIFICATION(20004,"亲，当前商品兑换名额不足！");

    private Integer errorCode;

    private String errorMsg;

    ErrorCode(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getErrorMsg() {
        return errorMsg;
    }

}
