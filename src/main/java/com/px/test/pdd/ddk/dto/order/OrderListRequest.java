package com.px.test.pdd.ddk.dto.order;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddRequest;
import com.px.test.pdd.ddk.PddConfig;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 14:57
 **/
@Data
public class OrderListRequest extends PddRequest<OrderListResponse> implements PddConfig {

    private String api = ORDER_LIST;

    private boolean needToken = true;

    /**
     * 必填
     * 最近90天内多多进宝商品订单更新时间--查询时间开始。note：此时间为时间戳，
     * 指格林威治时间 1970 年01 月 01 日 00 时 00 分 00 秒(北京时间 1970 年 01 月 01 日 08 时 00 分 00 秒)起至现在的总秒数
     */
    @JSONField(name = "start_update_time")
    private Long startUpdateTime;

    /**
     * 必填
     * 查询结束时间，和开始时间相差不能超过24小时。note：此时间为时间戳，
     * 指格林威治时间 1970 年01 月 01 日 00 时 00 分 00 秒(北京时间 1970 年 01 月 01 日 08 时 00 分 00 秒)起至现在的总秒数
     */
    @JSONField(name = "end_update_time")
    private Long endUpdateTime;

    @JSONField(name = "page_size")
    private Integer pageSize;//非必填 返回的每页结果订单数，默认为100，范围为10到100，建议使用40~50，可以提高成功率，减少超时数量。

    private Integer page;//非必填 第几页，从1到10000，默认1，注：使用最后更新时间范围增量同步时，必须采用倒序的分页方式（从最后一页往回取）才能避免漏单问题。

}
