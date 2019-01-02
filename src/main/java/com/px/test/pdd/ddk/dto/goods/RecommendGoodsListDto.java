package com.px.test.pdd.ddk.dto.goods;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description: 运营频道商品
 * @author: px
 * @create: 2018-12-25 17:18
 **/
@Data
public class RecommendGoodsListDto {

    @JSONField(name = "qr_code_image_url")
    private String qrCodeImageUrl;//二维码主图

    @JSONField(name = "lock_edit")
    private String lockEdit;//编辑锁定

    @JSONField(name = "broker")
    private String broker;//代理人

    @JSONField(name = "rank")
    private String rank;//顺序

    @JSONField(name = "sale_num_today")
    private Long saleNumToday;//今日成交量

    @JSONField(name = "sale_num24")
    private Long saleNum24;//成交量

    @JSONField(name = "serv_pct")
    private Double servPct;//服务评分击败同类店铺百分比

    @JSONField(name = "lgst_pct")
    private Double lgstPct;//物流评分击败同类店铺百分比

    @JSONField(name = "desc_pct")
    private Double descPct;//描述评分击败同类店铺百分比

    @JSONField(name = "avg_serv")
    private Long avgServ;//服务评分

    @JSONField(name = "avg_lgst")
    private Long avgLgst;//物流评分

    @JSONField(name = "avg_desc")
    private Long avgDesc;//描述评分

    @JSONField(name = "share_desc")
    private String shareDesc;//分享描述

    @JSONField(name = "cat_id")
    private String catId;//商品类目id

    @JSONField(name = "goods_eval_count")
    private Long goodsEvalCount;//商品评价数量

    @JSONField(name = "goods_eval_score")
    private Double goodsEvalScore;//商品评价分

    @JSONField(name = "market_fee")
    private Long marketFee;//市场服务费

    @JSONField(name = "goods_rate")
    private Long goodsRate;//商品等级

    @JSONField(name = "coupon_price")
    private Long couponPrice;//优惠券金额

    @JSONField(name = "promotion_rate")
    private Long promotionRate;//佣金比例,千分比

    @JSONField(name = "coupon_end_time")
    private Long couponEndTime;//优惠券失效时间,UNIX时间戳

    @JSONField(name = "coupon_start_time")
    private Long couponStartTime;//优惠券生效时间,UNIX时间戳

    @JSONField(name = "coupon_remain_quantity")
    private Long couponRemainQuantity;//优惠券剩余数量

    @JSONField(name = "coupon_total_quantity")
    private Long couponTotalQuantity;//优惠券总数量

    @JSONField(name = "coupon_discount")
    private Long couponDiscount;//优惠券面额,单位为分

    @JSONField(name = "coupon_min_order_amount")
    private Long couponMinOrderAmount;//优惠券门槛价格,单位为分

    @JSONField(name = "coupon_id")
    private Long couponId;//优惠券id

    @JSONField(name = "has_coupon")
    private Boolean hasCoupon;//商品是否带券,true-带券,false-不带券

    @JSONField(name = "goods_type")
    private Integer goodsType;//商品类型

    @JSONField(name = "cat_ids")
    private Long[] catIds;//商品一~四级类目ID列表

    @JSONField(name = "opt_ids")
    private Long[] optIds;//商品一~四级标签类目ID列表

    @JSONField(name = "opt_name")
    private String optName;//商品标签名

    @JSONField(name = "opt_id")
    private String optId;//商品标签类目ID,使用pdd.goods.opt.get获取

    @JSONField(name = "category_name")
    private String categoryName;//分类名称

    @JSONField(name = "category_id")
    private String categoryId;//类目id

    @JSONField(name = "merchant_type")
    private String merchantType;//商家类型

    @JSONField(name = "mall_name")
    private String mallName;//店铺名称

    @JSONField(name = "mall_id")
    private Long mallId;//商家id

    @JSONField(name = "min_normal_price")
    private Long minNormalPrice;//最小单买价格，单位分

    @JSONField(name = "min_group_price")
    private Long minGroupPrice;//最小成团价格，单位分

    @JSONField(name = "goods_fact_price")
    private Long goodsFactPrice;//商品实际价格

    @JSONField(name = "goods_mark_price")
    private Long goodsMarkPrice;//商品标准价格

    @JSONField(name = "sold_quantity")
    private Long soldQuantity;//销售

    @JSONField(name = "goods_gallery_urls")
    private String goodsGalleryUrls;//商品详情图列表

    @JSONField(name = "goods_image_url")
    private String goodsImageUrl;//商品主图

    @JSONField(name = "goods_thumbnail_url")
    private String goodsThumbnailUrl;//商品缩略图

    @JSONField(name = "goods_desc")
    private String goodsDesc;//商品描述

    @JSONField(name = "goods_name")
    private String goodsName;//商品名称

    @JSONField(name = "goods_id")
    private Long goodsId;//商品id

    @JSONField(name = "create_at")
    private Long createAt;//创建时间

}
