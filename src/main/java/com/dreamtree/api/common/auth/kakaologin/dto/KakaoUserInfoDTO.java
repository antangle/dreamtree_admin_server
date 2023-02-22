package com.dreamtree.api.common.auth.kakaologin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KakaoUserInfoDTO {

    private String account_email;

    private String profile_nickname;

    private String profile_image;

    private String thumbnail_image;

    private String birthday;

}
