package com.px.test.pdd.ddk.dto.prom;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddRequest;
import com.px.test.pdd.ddk.PddConfig;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 15:06
 **/
@Data
public class GoodsPromotionUrlRequest extends PddRequest<GoodsPromotionUrlResponse> implements PddConfig {

    private String api = PROMOTION_URL_GENERATE;

    private boolean needToken = true;

    @JSONField(name = "p_id")
    private String pId;//必填 推广位ID

    @JSONField(name = "goods_id_list")
    private Long[] goodsIdList;//必填  商品ID

    @JSONField(name = "generate_short_url")
    private Boolean generateShortUrl;//非必填 是否生成短链接，true-是，false-否


    /**
     * true--生成多人团推广链接 false--生成单人团推广链接（默认false）1、单人团推广链接：用户访问单人团推广链接，可直接购买商品无需拼团。
     * 2、多人团推广链接：用户访问双人团推广链接开团，若用户分享给他人参团，则开团者和参团者的佣金均结算给推手
     */
    @JSONField(name = "multi_group")
    private Boolean multiGroup;//非必填


    @JSONField(name = "custom_parameters")
    private String customParameters;//非必填  自定义参数，为链接打上自定义标签。自定义参数最长限制64个字节。


    @JSONField(name = "pull_new")
    private Boolean pullNew;//非必填 是否开启订单拉新，true表示开启（订单拉新奖励特权仅支持白名单，请联系工作人员开通）


    @JSONField(name = "generate_weapp_webview")
    private Boolean generateWeappWebview;//非必填 是否生成唤起微信客户端链接，true-是，false-否，默认false

    @JSONField(name = "zs_duo_id")
    private Long zsDuoId;//非必填 招商多多客ID

    @JSONField(name = "generate_we_app")
    private Boolean generateWeApp;//非必填 是否生成小程序推广

}
