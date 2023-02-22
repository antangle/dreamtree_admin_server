package com.dreamtree.api.common.auth.kakaologin.dto;

import lombok.Data;

@Data
public class KakaoTokenResDTO {

    private String accessToken;

    private String refreshToken;

}
