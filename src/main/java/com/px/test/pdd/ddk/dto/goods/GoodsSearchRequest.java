package com.px.test.pdd.ddk.dto.goods;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddRequest;
import com.px.test.pdd.ddk.PddConfig;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 13:44
 **/
@Data
public class GoodsSearchRequest extends PddRequest<GoodsSearchResponse> implements PddConfig {

    private String api = GOODS_SEARCH;

    private String keyword;//非必填 商品关键词，与opt_id字段选填一个或全部填写

    @JSONField(name = "opt_id")
    private Long optId;//非必填 商品标签类目ID，使用pdd.goods.opt.get获取

    @JSONField(name = "page")
    private Integer page;//非必填   默认值1，商品分页数

    @JSONField(name = "page_size")
    private Integer pageSize;//非必填 默认100，每页商品数量

    /**
     *  排序方式:0-综合排序;1-按佣金比率升序;2-按佣金比例降序;3-按价格升序;4-按价格降序;
     *  5-按销量升序;6-按销量降序;7-优惠券金额排序升序;8-优惠券金额排序降序;9-券后价升序排序;
     *  10-券后价降序排序;11-按照加入多多进宝时间升序;12-按照加入多多进宝时间降序;1
     *  3-按佣金金额升序排序;14-按佣金金额降序排序;15-店铺描述评分升序;16-店铺描述评分降序;
     *  17-店铺物流评分升序;18-店铺物流评分降序;19-店铺服务评分升序;20-店铺服务评分降序;27-描述评分击败同类店铺百分比升序，
     *  28-描述评分击败同类店铺百分比降序，29-物流评分击败同类店铺百分比升序，30-物流评分击败同类店铺百分比降序，
     *  31-服务评分击败同类店铺百分比升序，32-服务评分击败同类店铺百分比降序
     *
     */
    @JSONField(name = "sort_type")
    private Integer sortType;//非必填

    @JSONField(name = "with_coupon")
    private Boolean withCoupon;//非必填 是否只返回优惠券的商品，false返回所有商品，true只返回有优惠券的商品

    @JSONField(name = "range_list")
    private String rangeList;//非必填 范围列表，可选值：[{"range_id":0,"range_from":1,"range_to":1500},{"range_id":1,"range_from":1,"range_to":1500}]

    @JSONField(name = "cat_id")
    private Long catId;//非必填 商品类目ID，使用pdd.goods.cats.get接口获取

    @JSONField(name = "goods_id_list")
    private Long[] goodsIdList;//非必填 商品ID列表。例如：[123456,123]，当入参带有goods_id_list字段，将不会以opt_id、 cat_id、keyword维度筛选商品

    @JSONField(name = "zs_duo_id")
    private Long zsDuoId;//非必填 招商多多客ID

    @JSONField(name = "merchant_type")
    private Integer merchantType;//非必填 店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店（未传为全部）

    @JSONField(name = "pid")
    private String pid;//非必填  推广位id

    @JSONField(name = "custom_parameters")
    private String customParameters;//非必填 自定义参数

}
