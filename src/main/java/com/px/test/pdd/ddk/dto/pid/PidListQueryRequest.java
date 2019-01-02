package com.px.test.pdd.ddk.dto.pid;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddRequest;
import com.px.test.pdd.ddk.PddConfig;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 16:29
 **/
@Data
public class PidListQueryRequest extends PddRequest<PidQueryResponse> implements PddConfig {

    private String api = PID_QUERY;

    @JSONField(name = "page_size")
    private Integer pageSize;

    private Integer page;

}
