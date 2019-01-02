package com.px.test.pdd.ddk.dto.cats;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddResponse;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-20 18:35
 **/
@Data
public class GoodsCatsResponse extends PddResponse {

    @JSONField(name = "goods_cats_get_response")
    private GoodsCatsList data;
}
