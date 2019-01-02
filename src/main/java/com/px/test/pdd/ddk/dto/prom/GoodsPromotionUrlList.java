package com.px.test.pdd.ddk.dto.prom;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 11:40
 **/
@Data
public class GoodsPromotionUrlList {

    @JSONField(name = "goods_promotion_url_list")
    private List<PromUrlDto> promUrlDtoList;
}
