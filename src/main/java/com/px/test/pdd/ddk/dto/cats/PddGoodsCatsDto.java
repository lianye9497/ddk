package com.px.test.pdd.ddk.dto.cats;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description: 拼多多类目
 * @author: px
 * @create: 2018-12-20 18:31
 **/
@Data
public class PddGoodsCatsDto {

    private Integer level; //类目层级，1-一级类目，2-二级类目，3-三级类目，4-四级类目

    @JSONField(name = "cat_name")
    private String catName;//商品类目名称

    @JSONField(name = "parent_cat_id")
    private Long parentCatId;//  id所属父类目ID，其中，parent_id=0时为顶级节点

    @JSONField(name = "cat_id")
    private Long catId;//商品类目ID


}
