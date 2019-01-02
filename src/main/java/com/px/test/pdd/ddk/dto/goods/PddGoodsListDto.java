package com.px.test.pdd.ddk.dto.goods;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description:拼多多商品列表
 * @author: px
 * @create: 2018-12-20 15:30
 **/
@Data
public class PddGoodsListDto {

    //创建时间（unix时间戳）
    @JSONField(name = "create_at")
    private Long createAt;

    @JSONField(name = "goods_id")
    private Long goodsId;//商品id

    @JSONField(name = "goods_name")
    private String goodsName;// 商品名称

    @JSONField(name = "goods_desc")
    private String goodsDesc;//  商品描述

    @JSONField(name = "goods_thumbnail_url")
    private String goodsThumbnailUrl;// 商品缩略图

    @JSONField(name = "goods_image_url")
    private String goodsImageUrl;//商品主图

    @JSONField(name = "goods_gallery_urls")
    private String[] goodsGalleryUrls;//商品轮播图

    @JSONField(name = "sold_quantity")
    private Long soldQuantity;//已售卖件数

    @JSONField(name = "min_group_price")
    private Long minGroupPrice;//最小拼团价（单位为分）

    @JSONField(name = "min_normal_price")
    private Long minNormalPrice;//最小单买价格（单位为分）

    @JSONField(name = "mall_name")
    private String mallName;//店铺名字

    @JSONField(name = "merchant_type")
    private Integer merchantType;//店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店

    @JSONField(name = "category_id")
    private Long categoryId;// 商品类目ID，使用pdd.goods.cats.get接口获取

    @JSONField(name = "category_name")
    private String categoryName;//商品类目名

    @JSONField(name = "opt_id")
    private Long optId;//  商品标签ID，使用pdd.goods.opts.get接口获取

    @JSONField(name = "opt_name")
    private String optName;//商品标签名

    @JSONField(name = "opt_ids")
    private Long[] optIds;//商品标签id

    @JSONField(name = "cat_ids")
    private Long[] catIds;//商品类目id

    @JSONField(name = "mall_cps")
    private Integer mallCps;//    该商品所在店铺是否参与全店推广，0：否，1：是

    @JSONField(name = "has_coupon")
    private Boolean hasCoupon;//商品是否有优惠券 true-有，false-没有

    @JSONField(name = "coupon_min_order_amount")
    private Long couponMinOrderAmount;//  优惠券门槛价格，单位为分

    @JSONField(name = "coupon_discount")
    private Long couponDiscount;//优惠券面额，单位为分

    @JSONField(name = "coupon_total_quantity")
    private Long couponTotalQuantity;//优惠券总数量

    @JSONField(name = "coupon_remain_quantity")
    private Long couponRemainQuantity;//优惠券剩余数量

    @JSONField(name = "coupon_start_time")
    private Long couponStartTime;//优惠券生效时间，UNIX时间戳

    @JSONField(name = "coupon_end_time")
    private Long couponEndTime;//  优惠券失效时间，UNIX时间戳

    @JSONField(name = "promotion_rate")
    private Long promotionRate;//佣金比例，千分比

    @JSONField(name = "goods_eval_score")
    private Double goodsEvalScore;//商品评价分

    @JSONField(name = "goods_eval_count")
    private Long goodsEvalCount;//商品评价数量

    @JSONField(name = "avg_desc")
    private Long avgDesc;//描述评分

    @JSONField(name = "avg_lgst")
    private Long avgLgst;//物流评分

    @JSONField(name = "avg_serv")
    private Long avgServ;//服务评分

    @JSONField(name = "desc_pct")
    private Double descPct;//描述分击败同类店铺百分比

    @JSONField(name = "lgst_pct")
    private Double lgstPct;//物流分击败同类店铺百分比

    @JSONField(name = "serv_pct")
    private Double servPct;//服务分击败同类店铺百分比

}
