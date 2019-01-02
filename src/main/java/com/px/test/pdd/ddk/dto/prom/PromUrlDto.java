package com.px.test.pdd.ddk.dto.prom;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 11:29
 **/
@Data
public class PromUrlDto {

    @JSONField(name = "we_app_web_view_short_url")
    private String weAppWebViewShortUrl;//唤起微信app推广短链接

    @JSONField(name = "we_app_web_view_url")
    private String weAppWebViewUrl;//  唤起微信app推广链接

    @JSONField(name = "mobile_short_url")
    private String mobileShortUrl;//唤醒拼多多app的推广短链接

    @JSONField(name = "mobile_url")
    private String mobileUrl;//唤醒拼多多app的推广长链接

    @JSONField(name = "short_url")
    private String shortUrl;//推广短链接

    @JSONField(name = "url")
    private String url;//推广长链接

    @JSONField(name = "we_app_info")
    private WeAppInfo weAppInfo;

}
