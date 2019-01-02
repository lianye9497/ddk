package com.px.test.pdd.ddk;

import lombok.Data;

import java.lang.reflect.ParameterizedType;

/**
 * @description:
 * @author: px
 * @create: 2018-12-20 16:55
 **/
@Data
public class PddRequest<T extends PddResponse> {

    private boolean needToken;

    private String api;

    public Class<T> getResponseClass() {
        return (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
