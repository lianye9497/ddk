package com.px.test.pdd.ddk;

import com.alibaba.fastjson.JSON;
import com.px.test.pdd.ddk.dto.cats.GoodsCatsRequest;
import com.px.test.pdd.ddk.dto.cats.GoodsCatsResponse;
import com.px.test.pdd.ddk.dto.goods.GoodsSearchRequest;
import com.px.test.pdd.ddk.dto.goods.GoodsSearchResponse;
import com.px.test.pdd.ddk.dto.goods.RecommendGoodsRequest;
import com.px.test.pdd.ddk.dto.goods.RecommendGoodsResponse;
import com.px.test.pdd.ddk.dto.oAuth.OAuthResult;
import com.px.test.pdd.ddk.dto.order.OrderListRequest;
import com.px.test.pdd.ddk.dto.order.OrderListResponse;
import com.px.test.pdd.ddk.dto.pid.PidListQueryRequest;
import com.px.test.pdd.ddk.dto.pid.PidListRequest;
import com.px.test.pdd.ddk.dto.pid.PidListResponse;
import com.px.test.pdd.ddk.dto.pid.PidQueryResponse;
import com.px.test.pdd.ddk.dto.prom.GoodsPromotionUrlRequest;
import com.px.test.pdd.ddk.dto.prom.GoodsPromotionUrlResponse;
import com.px.test.pdd.util.JedisUtil;
import com.px.test.pdd.util.OkHttpUtil;
import com.px.test.pdd.util.SpringApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @description:
 * @author: px
 * @create: 2018-12-20 10:36
 **/
@Slf4j
public class PddUtil implements PddConfig {

    private static volatile JedisUtil jedisUtil;

    /**
     * 搜索商品
     *
     * @param request
     */
    public static GoodsSearchResponse goodsSearch(GoodsSearchRequest request) {
        return PddClient.execute(request);
    }

    /**
     * 运营频道商品查询
     *
     * @param request
     * @return
     */
    public static RecommendGoodsResponse recommendGoodsResponse(RecommendGoodsRequest request) {
        return PddClient.execute(request);
    }

    public static void main(String[] args) {
        System.out.println(oAuthUrl());
    }

    /**
     * 获取类目
     *
     * @param parentCatId
     */
    public static GoodsCatsResponse goodsCats(long parentCatId) {
        GoodsCatsRequest request = new GoodsCatsRequest();
        request.setParentCatId(parentCatId);
        return PddClient.execute(request);
    }


    /**
     * 同步订单
     *
     * @param request
     * @return
     */
    public static OrderListResponse orderList(OrderListRequest request) {
        return PddClient.execute(request);
    }

    /**
     * 授权地址
     *
     * @return
     */
    public static String oAuthUrl() {
        return String.format(OAUTH_URL, CLIENT_ID, REDIRECT_URI + "/api/tkb/OAuth/redirect");
    }

    /**
     * 授权
     *
     * @param code
     */
    public static boolean oAuth(String code) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("client_id", CLIENT_ID);
        urlParams.put("client_secret", CLIENT_SECRET);
        urlParams.put("grant_type", "authorization_code");
        urlParams.put("code", code);
        urlParams.put("redirect_uri", REDIRECT_URI);
        urlParams.put("state", "221");
        String result = OkHttpUtil.requestOfPost(OAUTH_TOKEN_URL, urlParams);
        System.out.println(result);
        if (StringUtils.isEmpty(result)) {
            return false;
        }
        OAuthResult oAuthResult = JSON.parseObject(result, OAuthResult.class);
        if (oAuthResult != null && !StringUtils.isEmpty(oAuthResult.getAccessToken())){
            JedisUtil bean = getJedisUtil();
            bean.set(OAUTH_TOKEN, result);
            return true;
        }
        return false;
    }

    private static JedisUtil getJedisUtil(){
        if (jedisUtil == null){
            synchronized (PddUtil.class){
                if (jedisUtil == null){
                    jedisUtil = SpringApplicationContextUtil.getBean(JedisUtil.class);
                }
            }
        }
        return jedisUtil;
    }

    public static String getAccessToken(){
        OAuthResult oAuthResult = getOAuthResult();
        if (oAuthResult == null){
            return null;
        }
        return oAuthResult.getAccessToken();
    }

    private static String getRefreshToken(){
        OAuthResult oAuthResult = getOAuthResult();
        if (oAuthResult == null){
            return null;
        }
        return oAuthResult.getRefreshToken();
    }

    private static OAuthResult getOAuthResult(){
        JedisUtil jedisUtil = getJedisUtil();
        String result = jedisUtil.get(OAUTH_TOKEN);
        if (StringUtils.isEmpty(result)) {
            return null;
        }
        OAuthResult oAuthResult = JSON.parseObject(result, OAuthResult.class);
        if (oAuthResult != null && !StringUtils.isEmpty(oAuthResult.getAccessToken())){
            return oAuthResult;
        }
        return null;
    }

    public static void refreshToken() {
        String refreshToken = getRefreshToken();
        if (StringUtils.isEmpty(refreshToken)) {
            log.error("刷新授权失败,获取拼多多refreshToken失败");
            return;
        }
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("client_id", CLIENT_ID);
        urlParams.put("client_secret", CLIENT_SECRET);
        urlParams.put("grant_type", "refresh_token");
        urlParams.put("refresh_token", refreshToken);
        urlParams.put("state", "221");
        String result = OkHttpUtil.requestOfPost(OAUTH_TOKEN_URL, urlParams);
        System.out.println(result);
        if (StringUtils.isEmpty(result)) {
            return;
        }
        JedisUtil bean = getJedisUtil();
        bean.set(OAUTH_TOKEN, result);
    }

    /**
     * 生成推广链接
     *
     * @param
     */
    public static GoodsPromotionUrlResponse goodsPromotionUrlGenerate(GoodsPromotionUrlRequest request) {
        if (request.getGenerateShortUrl() == null) request.setGenerateShortUrl(true);
        if (request.getMultiGroup() == null) request.setMultiGroup(false);
        if (request.getGenerateWeappWebview() == null) request.setGenerateWeappWebview(true);
        if (request.getGenerateWeApp() == null) request.setGenerateWeApp(true);
        if (StringUtils.isEmpty(request.getCustomParameters())) request.setCustomParameters("xiaoy");
        return PddClient.execute(request);
    }

    /**
     * PID生成
     *
     * @param request
     * @return
     */
    public static PidListResponse goodsPidGenerate(PidListRequest request) {
        return PddClient.execute(request);
    }

    /**
     * PID列表查询
     *
     * @param request
     * @return
     */
    public static PidQueryResponse pidListQuery(PidListQueryRequest request) {
        return PddClient.execute(request);
    }


}


