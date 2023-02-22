package com.dreamtree.api.common.auth.kakaologin.service;

import com.dreamtree.api.common.auth.kakaologin.dto.KakaoReqDTO;
import com.dreamtree.api.common.auth.kakaologin.dto.KakaoReqTokenDTO;
import com.dreamtree.api.common.auth.kakaologin.dto.KakaoResDTO;
import com.dreamtree.api.common.auth.kakaologin.dto.KakaoUserInfoDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoResDTO;
import com.dreamtree.api.domain.student.dto.StudentDetailDTO;

public interface KakaoLoginService {

    KakaoResDTO ParentSignIn(KakaoReqDTO reqDTO);

    KakaoResDTO StudentSignIn(KakaoReqDTO reqDTO);

    int signUp(KakaoReqDTO reqDTO);

    KakaoUserInfoDTO getKakaoUserInfo(String accessToken);

    KakaoReqTokenDTO generateToken(String code);

    KakaoReqTokenDTO refreshToken(String refreshToken);

    KakaoReqTokenDTO getKakaoTokenInfo(String accessToken);

}
