package com.dreamtree.api.common.auth.kakaologin.dto;

import lombok.Data;

/** 최서연 ver.0.1 **/

@Data
public class KakaoTokenResDTO {

    private String accessToken;

    private String refreshToken;

}
