package com.px.test.pdd.ddk.dto.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description: 拼多多订单List 返回实体
 * @author: px
 * @create: 2018-12-20 20:47
 **/
@Data
public class OrderListDto {

    @JSONField(name = "order_verify_time")
    private Long orderVerifyTime;//审核时间

    @JSONField(name = "order_pay_time")
    private Long orderPayTime;//支付时间

    @JSONField(name = "order_group_success_time")
    private Long orderGroupSuccessTime;//成团时间

    @JSONField(name = "order_modify_at")
    private Long orderModifyAt;//最后更新时间

    @JSONField(name = "order_status_desc")
    private String orderStatusDesc;//订单状态描述

    @JSONField(name = "p_id")
    private String pId;//推广位ID

    @JSONField(name = "order_status")
    private Integer orderStatus;//    订单状态： -1 未支付; 0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）

    @JSONField(name = "promotion_amount")
    private Long promotionAmount;//佣金金额，单位为分

    @JSONField(name = "promotion_rate")
    private Long promotionRate;// 佣金比例，千分比

    @JSONField(name = "order_create_time")
    private Long orderCreateTime;//订单生成时间，UNIX时间戳

    @JSONField(name = "order_amount")
    private Long orderAmount;//实际支付金额，单位为分

    @JSONField(name = "goods_price")
    private Long goodsPrice;//订单中sku的单件价格，单位为分

    @JSONField(name = "goods_quantity")
    private Long goodsQuantity;//购买商品的数量

    @JSONField(name = "goods_thumbnail_url")
    private String goodsThumbnailUrl;//商品缩略图

    @JSONField(name = "goods_name")
    private String goodsName;//商品标题

    @JSONField(name = "goods_id")
    private Long goodsId;//商品ID

    @JSONField(name = "order_sn")
    private String orderSn;//推广订单编号


}
