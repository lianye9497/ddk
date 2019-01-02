package com.px.test.pdd.ddk.dto.goods;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddResponse;

/**
 * @description:
 * @author: px
 * @create: 2018-12-25 17:38
 **/
public class RecommendGoodsResponse extends PddResponse {

    @JSONField(name = "goods_basic_detail_response")
    private RecommendGoodsList data;//二维码主图

}
