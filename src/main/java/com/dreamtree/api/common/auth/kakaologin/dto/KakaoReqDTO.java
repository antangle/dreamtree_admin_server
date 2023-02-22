package com.dreamtree.api.common.auth.kakaologin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KakaoReqDTO {

    private String pathValue;

    private KakaoUserInfoDTO userInfoDTO;

}
