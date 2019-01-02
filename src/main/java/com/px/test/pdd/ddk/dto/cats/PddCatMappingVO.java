package com.px.test.pdd.ddk.dto.cats;

import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-29 16:00
 **/
@Data
public class PddCatMappingVO {


    private Integer level; //类目层级，1-一级类目，2-二级类目，3-三级类目，4-四级类目

    private String catId;//商品类目ID

    private String catName;//商品类目名称

    private String parentCatId;//  id所属父类目ID，其中，parent_id=0时为顶级节点

    private String parentCatName;//商品父类目名称

}
