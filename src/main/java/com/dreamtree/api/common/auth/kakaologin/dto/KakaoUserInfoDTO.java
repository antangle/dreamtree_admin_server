package com.dreamtree.api.common.auth.kakaologin.dto;

import lombok.Data;

/** 최서연 ver.0.1 **/
@Data
public class KakaoUserInfoDTO {

    private String account_email;

    private String profile_nickname;

    private String profile_image;

    private String thumbnail_image;

    private String birthday;

}
