package com.px.test.pdd.ddk.dto.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: px
 * @create: 2018-12-20 20:48
 **/
@Data
public class OrderList {

    @JSONField(name = "order_list")
    private List<OrderListDto> orders;

    @JSONField(name = "total_count")
    private int totalCount;
}
