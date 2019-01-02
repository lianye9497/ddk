package com.px.test.pdd.ddk;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.dto.PddErrorResponse;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-20 16:50
 **/
@Data
public class PddResponse {

    private boolean success;

    private boolean needToken;

    @JSONField(name = "error_response")
    private PddErrorResponse errorResponse;


}
