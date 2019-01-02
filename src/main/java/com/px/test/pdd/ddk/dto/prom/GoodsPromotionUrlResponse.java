package com.px.test.pdd.ddk.dto.prom;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddResponse;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 11:41
 **/
@Data
public class GoodsPromotionUrlResponse extends PddResponse {

    @JSONField(name = "goods_promotion_url_generate_response")
    private GoodsPromotionUrlList data;

    private boolean needToken = true;

}
