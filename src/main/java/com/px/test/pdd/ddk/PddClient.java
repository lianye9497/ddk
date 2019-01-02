package com.px.test.pdd.ddk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.excption.BaseException;
import com.px.test.pdd.util.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: px
 * @create: 2018-12-20 16:49
 **/
@Slf4j
public class PddClient implements PddConfig {

    public static <T extends PddResponse> T execute(String api, Map<String, String> urlParams, Class<T> tClass) {
        T o = setAccessToken(urlParams, tClass);
        String commonUrl = getCommonUrl(api, urlParams);
        System.out.println(commonUrl);
        String json = OkHttpUtil.requestOfPost(commonUrl, urlParams);
        T result = JSON.parseObject(json, tClass);
        if (result == null) return o;
        result.setSuccess(true);
        return result;
    }

    public static <T extends PddResponse> T execute(PddRequest<T> request) {
        Map<String, String> params = getParam(request);
        String commonUrl = getCommonUrl(request.getApi(), params);
        String json = OkHttpUtil.requestOfPost(commonUrl, params);
        T result = JSON.parseObject(json, request.getResponseClass());
        if (result == null) {
            log.error("请求{}失败,原因={}", request.getApi(), json);
            return failResponse(request.getResponseClass());
        }
        if (result.getErrorResponse() != null) {
            log.error("请求{}失败,原因={}", request.getApi(), json);
            return result;
        }
        result.setSuccess(true);
        return result;
    }

    private static <T extends PddResponse> Map<String, String> getParam(PddRequest<T> request) {
        Map<String, String> params = new HashMap<>();
        Field[] declaredFields = request.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            JSONField annotation = field.getAnnotation(JSONField.class);
            String name = annotation == null ? field.getName() : annotation.name();
            if ("api".equals(name) || "needToken".equals(name)) continue;
            try {
                String value = null;
                Object o = field.get(request);
                if (o == null) continue;
                if (o.getClass().isArray()) {
                    value = JSON.toJSONString(o);
                } else {
                    value = String.valueOf(o);
                }
                params.put(name, value);
            } catch (IllegalAccessException e) {
                log.info("获取字段属性失败");
            }
        }
        putAccessToken(params, request.isNeedToken());
        return params;
    }

    private static String getCommonUrl(String api, Map<String, String> urlParams) {
        return sign(api, urlParams);
    }


    private static <T extends PddResponse> T setAccessToken(Map<String, String> urlParams, Class<T> tClass) {
        T o = failResponse(tClass);
        putAccessToken(urlParams, o.isNeedToken());
        return o;
    }

    private static void putAccessToken(Map<String, String> urlParams, boolean status) {
        if (status) {
            urlParams.put("access_token", PddUtil.getAccessToken());
        }
    }

    private static <T extends PddResponse> T failResponse(Class<T> tClass) {
        try {
            return tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BaseException("pdd接口请求异常");
        }
    }


    private static String sign(String api, Map<String, String> urlParams) {
        long times = System.currentTimeMillis() / 1000;
        Map<String, String> map = new TreeMap<>();
        map.put("type", api);
        map.put("data_type", "JSON");
        map.put("client_id", CLIENT_ID);
        map.put("timestamp", String.valueOf(times));
        map.putAll(urlParams);
        Map<String, String> sortMap = sortMapByKey(map);
        StringBuilder sb = new StringBuilder();
        sb.append(CLIENT_SECRET);
        sortMap.keySet().forEach(item -> sb.append(item).append(sortMap.get(item)));
        sb.append(CLIENT_SECRET);
        String sign = encryptMD5(sb.toString());
        return String.format(FORMAT_DOMAIN, api, times, CLIENT_ID) + AND + "sign=" + sign;
    }

    private static String encryptMD5(String data) {
        try {
            return DigestUtils.md5Hex(data.getBytes("UTF-8")).toUpperCase();
        } catch (UnsupportedEncodingException e) {
            log.error("MD5加密失败", data);
        }
        return null;
    }


    /**
     * 使用 Map按key进行排序
     *
     * @param map
     * @return
     */
    private static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }


}

class MapKeyComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
}
