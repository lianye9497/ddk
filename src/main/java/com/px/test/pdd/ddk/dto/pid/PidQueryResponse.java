package com.px.test.pdd.ddk.dto.pid;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddResponse;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 16:25
 **/
@Data
public class PidQueryResponse extends PddResponse {

    @JSONField(name = "p_id_query_response")
    private PidList data;

}
