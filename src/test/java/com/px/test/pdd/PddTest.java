package com.px.test.pdd;

import com.px.test.pdd.ddk.PddUtil;
import com.px.test.pdd.ddk.dto.goods.GoodsSearchList;
import com.px.test.pdd.ddk.dto.goods.GoodsSearchRequest;
import com.px.test.pdd.ddk.dto.goods.GoodsSearchResponse;

/**
 * @description:
 * @author: px
 * @create: 2019-01-02 10:56
 **/
public class PddTest {

    public static void main(String[] args) {
        GoodsSearchRequest request = new GoodsSearchRequest();
        request.setKeyword("男装");
        GoodsSearchResponse response = PddUtil.goodsSearch(request);
        if (!response.isSuccess()){
            return;
        }
        GoodsSearchList data = response.getData();
        System.out.println(data.getTotalCount());
    }
}
