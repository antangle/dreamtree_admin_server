package com.dreamtree.api.common.auth.kakaologin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/** 최서연 ver.0.1 **/
@Data
public class KakaoReqTokenDTO {

    @JsonProperty(value = "token_type")
    private String tokenType;

    @JsonProperty(value = "access_token")
    private String accessToken;

    @JsonProperty(value = "refresh_token")
    private String refreshToken;

    @JsonProperty(value = "expires_in")
    private Long expiresIn;

    @JsonProperty(value = "refresh_token_expires_in")
    private Long refreshTokenExpiresIn;

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "expiresInMillis")
    private Long expiresInMillis;

    @JsonProperty(value = "appId")
    private Long appId;

    @JsonProperty(value = "code")
    private Integer code;
}
