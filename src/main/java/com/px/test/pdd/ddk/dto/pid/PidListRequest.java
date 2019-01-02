package com.px.test.pdd.ddk.dto.pid;

import com.alibaba.fastjson.annotation.JSONField;
import com.px.test.pdd.ddk.PddRequest;
import com.px.test.pdd.ddk.PddConfig;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 15:25
 **/
@Data
public class PidListRequest extends PddRequest<PidListResponse> implements PddConfig {

    private boolean needToken = true;

    private String api = PID_GENERATE;

    private Long number;//必填 要生成的推广位数量，默认为10，范围为：1~100

    @JSONField(name = "p_id_name_list")
    private String[] pIdNameList;//非必填 推广位名称，例如["1","2"]

}
