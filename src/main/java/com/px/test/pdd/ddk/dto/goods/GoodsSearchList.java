package com.px.test.pdd.ddk.dto.goods;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: px
 * @create: 2018-12-20 16:22
 **/
@Data
public class GoodsSearchList {

    @JSONField(name = "goods_list")
    private List<PddGoodsListDto> goodsList;

    @JSONField(name = "total_count")
    private int totalCount;


}
