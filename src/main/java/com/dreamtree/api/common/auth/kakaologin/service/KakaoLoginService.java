package com.dreamtree.api.common.auth.kakaologin.service;

import com.dreamtree.api.common.auth.kakaologin.dto.KakaoUserInfoDTO;

public interface KakaoLoginService {

    int signIn(Long kakaoId);

    int signUp(String code);

    KakaoUserInfoDTO getKakaoUserInfo(String accessToken);

//    KakaoToken generateToken(String code);
//
//    KakaoToken refreshToken(String refreshToken);
//
//    KakaoToken getKakaoTokenInfo(String accessToken);

}
