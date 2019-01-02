package com.px.test.pdd.ddk.dto.goods;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: px
 * @create: 2018-12-25 17:37
 **/
@Data
public class RecommendGoodsList {

    private List<RecommendGoodsListDto> list;

    private String total;

}
