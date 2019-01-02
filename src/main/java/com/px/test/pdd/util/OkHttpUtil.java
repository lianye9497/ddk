package com.px.test.pdd.util;

 import com.alibaba.fastjson.JSON;
 import lombok.extern.slf4j.Slf4j;
 import okhttp3.*;

 import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: px
 * @create: 2018-12-20 11:03
 **/
@Slf4j
public class OkHttpUtil {

    private OkHttpUtil() {
        throw new IllegalStateException("Utility class");
    }

    private static OkHttpClient getClient() {
        return new OkHttpClient.Builder().build();
    }

    private static OkHttpClient getClient(long timeout) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.MILLISECONDS);
        return builder.build();
    }

    private static Request getRequest(String url, okhttp3.RequestBody requestBody, Map<String, String> headers) {
        Request.Builder builder = new Request.Builder().url(url);
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        builder.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");
        builder.addHeader("Connection", "keep-alive");
        if (requestBody != null) {
            builder.post(requestBody);
        }
        return builder.build();
    }

    private static String handleUrl(String url, Map<String, String> urlParams) {
        if (urlParams == null || urlParams.isEmpty()) {
            return url;
        }
        if (url.lastIndexOf("?") == -1) {
            url = url + "?";
        }
        for (Map.Entry<String, String> entry : urlParams.entrySet()) {
            String v = entry.getValue();
            if (v.lastIndexOf(";") != -1) {
                v = v.substring(0, v.lastIndexOf(";"));
            }
            url += "&" + entry.getKey() + "=" + v;
        }

        return url;
    }

    public static String requestOfGet(String url, Map<String, String> headers, Map<String, String> urlParams) {
        url = handleUrl(url, urlParams);
        OkHttpClient okHttpClient = getClient(5000);
        Request request = getRequest(url, null, headers);
        Call call = okHttpClient.newCall(request);
        try (Response response = call.execute()) {
            if (response.code() == 200) {
                String result = response.body().string();
                return result;
            }
            return "";
        } catch (IOException e) {
            log.error("OkHttpUtil.requestOfGet请求异常：", e);
        } catch (Exception ex) {
            log.error("OkHttpUtil.requestOfGet其他异常信息：", ex);
        }
        return "";
    }

    public static String requestOfPost(String url, Map<String, String> urlParams) {
        OkHttpClient okHttpClient = getClient(5000);
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(urlParams));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) {
                return response.body().string();
            }
        } catch (IOException e) {
            log.error("OkHttpUtil.requestOfPost请求异常：", e);
        }
        return null;
    }

}
