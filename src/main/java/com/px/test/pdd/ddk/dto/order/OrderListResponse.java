package com.px.test.pdd.ddk.dto.order;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddResponse;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-20 20:46
 **/
@Data
public class OrderListResponse extends PddResponse {

    @JSONField(name = "order_list_get_response")
    private OrderList data;

    private boolean needToken = true;

}
