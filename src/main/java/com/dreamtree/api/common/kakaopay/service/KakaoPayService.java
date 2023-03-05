package com.dreamtree.api.common.kakaopay.service;

import com.dreamtree.api.common.kakaopay.dto.KakaoApproveResponseDTO;
import com.dreamtree.api.common.kakaopay.dto.KakaoPayApproveDTO;
import com.dreamtree.api.common.kakaopay.dto.KakaoReadyRequestDTO;
import com.dreamtree.api.common.kakaopay.dto.KakaoReadyResponseDTO;

/** 이승윤 ver.0.1 **/
public interface KakaoPayService {
    KakaoReadyResponseDTO kakaoPayReady(KakaoReadyRequestDTO kakaoReadyRequestDTO);

    KakaoApproveResponseDTO approveResponse(KakaoPayApproveDTO kakaoPayApproveDTO);
}
