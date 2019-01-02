package com.px.test.pdd.ddk.dto.cats;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddRequest;
import com.px.test.pdd.ddk.PddConfig;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 15:11
 **/
@Data
public class GoodsCatsRequest extends PddRequest<GoodsCatsResponse> implements PddConfig {

    private String api = GOODS_CATS;

    @JSONField(name = "parent_cat_id")
    private long parentCatId;

}
