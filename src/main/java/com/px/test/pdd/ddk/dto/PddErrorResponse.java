package com.px.test.pdd.ddk.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 16:47
 **/
@Data
public class PddErrorResponse {

    @JSONField(name = "error_msg")
    private String errorMsg;

    @JSONField(name = "sub_msg")
    private String subMsg;

    @JSONField(name = "sub_code")
    private String subCode;

    @JSONField(name = "error_code")
    private String errorCode;

    @JSONField(name = "request_id")
    private String requestId;
}
