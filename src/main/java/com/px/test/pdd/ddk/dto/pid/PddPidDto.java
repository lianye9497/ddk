package com.px.test.pdd.ddk.dto.pid;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 15:21
 **/
@Data
public class PddPidDto {

    @JSONField(name = "pid_name")
    private String pIdName;//推广位名称

    @JSONField(name = "p_id")
    private String pId;//调用方推广位ID

    @JSONField(name = "create_time")
    private Long createTime;//推广位生成时间

}
