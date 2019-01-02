package com.px.test.pdd.ddk;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 10:09
 **/
public interface PddConfig {

    String CLIENT_ID = "c2b86552129d44b98e2bfee57f976e4a";

    String CLIENT_SECRET = "7121000dabff800bc60804438e950102aab5f0e8";

    //API请求地址
    String DOMAIN = "https://gw-api.pinduoduo.com/api/router";

    String AND = "&";

    String QUESTION_MARK = "?";

    //API通用地址
    String FORMAT_DOMAIN = "https://gw-api.pinduoduo.com/api/router?type=%s&data_type=JSON&timestamp=%s&client_id=%s";

    //授权重定向地址
    String REDIRECT_URI = "https://m.39ysj.com";

    //授权请求地址
    String OAUTH_TOKEN_URL = "https://open-api.pinduoduo.com/oauth/token";

    String OAUTH_TOKEN = "pdd_oauth_token";

    //换取授权code
    String OAUTH_URL = "https://jinbao.pinduoduo.com/open.html?client_id=%s&response_type=code&redirect_uri=%s";

    //    -------------------------------------------------------API---------------------------------------------------------------
    //商品查询
    String GOODS_SEARCH = "pdd.ddk.goods.search";

    //类目
    String GOODS_CATS = "pdd.goods.cats.get";

    //订单查询（所有)
    String ALL_ORDER_LIST = "pdd.ddk.all.order.list.increment.get";

    String ORDER_LIST = "pdd.ddk.order.list.increment.get";

    //PID 生成
    String PID_GENERATE = "pdd.ddk.oauth.goods.pid.generate";

    //推广链接生成
    String PROMOTION_URL_GENERATE = "pdd.ddk.goods.promotion.url.generate";

    //查询PID列表
    String PID_QUERY = "pdd.ddk.goods.pid.query";

    //运营频道商品查询
    String RECOMMEND_GOODS_SEARCH = "goods.recommend.get";
}
