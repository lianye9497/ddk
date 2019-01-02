package com.px.test.pdd.ddk.dto.cats;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: px
 * @create: 2018-12-20 18:30
 **/
@Data
public class GoodsCatsList {

    @JSONField(name = "goods_cats_list")
    private List<PddGoodsCatsDto> goodsCats;
}
