package com.px.test.pdd.ddk.dto.goods;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddResponse;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-20 16:26
 **/
@Data
public class GoodsSearchResponse extends PddResponse {

    @JSONField(name = "goods_search_response")
    private GoodsSearchList data;

}
