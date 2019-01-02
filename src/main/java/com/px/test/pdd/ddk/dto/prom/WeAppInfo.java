package com.px.test.pdd.ddk.dto.prom;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 11:35
 **/
@Data
public class WeAppInfo {

    @JSONField(name = "we_app_icon_url")
    private String weAppIconUrl;//小程序图片

    @JSONField(name = "banner_url")
    private String bannerUrl;//Banner图

    @JSONField(name = "desc")
    private String desc;//描述

    @JSONField(name = "source_display_name")
    private String sourceDisplayName;//来源名

    @JSONField(name = "page_path")
    private String pagePath;//小程序path值

    @JSONField(name = "user_name")
    private String userName;//用户名

    @JSONField(name = "title")
    private String title;//小程序标题

    @JSONField(name = "app_id")
    private String appId;//拼多多小程序id


}
