package com.px.test.pdd.ddk.dto.goods;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddConfig;
import com.px.test.pdd.ddk.PddRequest;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-25 17:39
 **/
@Data
public class RecommendGoodsRequest extends PddRequest<RecommendGoodsResponse> implements PddConfig {

    private String api = RECOMMEND_GOODS_SEARCH;

    private Integer offset;//非必填 从多少位置开始请求；默认值 ： 0

    private Integer limit;//非必填 请求数量；默认值 ： 400

    @JSONField(name = "channel_type")
    private Integer channelType;//非必填 频道类型；0, "1.9包邮", 1, "今日爆款", 2, "品牌清仓", 3, "默认商城", 非必填 ,默认是1

    @JSONField(name = "pid")
    private String pid;//非必填 推广位id

    @JSONField(name = "custom_parameters")
    private String customParameters;//非必填 自定义参数


}
