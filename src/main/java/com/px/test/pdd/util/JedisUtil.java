package com.px.test.pdd.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: px
 * @create: 2019-01-02 10:09
 **/
@Slf4j
public class JedisUtil {

    public void set(String oauthToken, String result) {
        log.info("设置缓存->key={},value={}", oauthToken, result);
    }

    public String get(String oauthToken) {
        log.info("获取缓存->key" + oauthToken);
        return "";
    }
}
