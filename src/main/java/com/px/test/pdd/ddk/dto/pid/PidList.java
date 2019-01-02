package com.px.test.pdd.ddk.dto.pid;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 15:22
 **/
@Data
public class PidList {

    @JSONField(name = "p_id_list")
    private List<PddPidDto> pidDtos;

    @JSONField(name = "total_count")
    private int totalCount;
}
