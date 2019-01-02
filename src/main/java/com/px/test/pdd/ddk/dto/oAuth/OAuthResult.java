package com.px.test.pdd.ddk.dto.oAuth;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: px
 * @create: 2018-12-21 10:03
 **/
@Data
public class OAuthResult {

    private List<String> scope;

    @JSONField(name = "access_token")
    private String accessToken;

    @JSONField(name = "expires_in")
    private String expiresIn;

    @JSONField(name = "refresh_token")
    private String refreshToken;

    @JSONField(name = "owner_id")
    private String  ownerId;

    @JSONField(name = "owner_name")
    private String ownerName;
}
