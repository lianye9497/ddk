package com.px.test.pdd.excption;

import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2019-01-02 10:53
 **/
@Data
public class BaseResult<T> {

    protected int code;
    protected String msg;
    protected T data;
    protected Boolean success;


}
