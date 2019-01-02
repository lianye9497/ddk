package com.px.test.pdd.ddk.dto.pid;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddResponse;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 15:23
 **/
@Data
public class PidListResponse extends PddResponse {

    @JSONField(name = "p_id_generate_response")
    private PidList data;

    private boolean needToken = true;

}
