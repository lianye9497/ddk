package com.px.test.pdd.excption;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description:
 * @author: suding
 * @create: 2018-06-09 12:24
 **/
@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public BaseResult handlerMyException(BaseException e) {
        BaseResult result = new BaseResult();
        if (e != null && e instanceof BaseException) {
            result.setCode(e.getErrorCode());
            result.setMsg(e.getMessage());
            log.info(result.toString());
        } else {
            //将系统异常以打印出来
            log.info("[系统异常]{}", e);
            result.setCode(ErrorCode.SYSTEM_ERROR.getErrorCode());
            result.setMsg(ErrorCode.SYSTEM_ERROR.getErrorMsg());
        }
        return result;
    }
}
