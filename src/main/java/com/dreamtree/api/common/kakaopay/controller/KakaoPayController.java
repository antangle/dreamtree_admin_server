package com.dreamtree.api.common.kakaopay.controller;

import com.dreamtree.api.common.enums.ErrorEnum;
import com.dreamtree.api.common.kakaopay.dto.KakaoApproveResponseDTO;
import com.dreamtree.api.common.kakaopay.dto.KakaoPayApproveDTO;
import com.dreamtree.api.common.kakaopay.dto.KakaoReadyRequestDTO;
import com.dreamtree.api.common.kakaopay.dto.KakaoReadyResponseDTO;
import com.dreamtree.api.common.kakaopay.service.KakaoPayService;
import com.dreamtree.api.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("api/payment")
@RequiredArgsConstructor
public class KakaoPayController {

    private final KakaoPayService kakaoPayService;
    @PostMapping("/ready")
    public KakaoReadyResponseDTO readyKakaoPay(@RequestBody KakaoReadyRequestDTO kakaoReadyRequestDTO) {
        log.info(kakaoReadyRequestDTO);
        return kakaoPayService.kakaoPayReady(kakaoReadyRequestDTO);
    }

    @PostMapping("/approve")
    public KakaoApproveResponseDTO approveKakaoPay(@RequestBody KakaoPayApproveDTO kakaoPayApproveDTO) {
        log.info(kakaoPayApproveDTO);
        return kakaoPayService.approveResponse(kakaoPayApproveDTO);
    }

    /**
     * 결제 진행 중 취소
     */
    @GetMapping("/cancel")
    public void cancel(@PathVariable("payId") String payId) {
        log.info("kakao pay cancel with payId: " + payId);
        throw new CustomException(ErrorEnum.KAKAO_PAY_CANCEL);
    }

    /**
     * 결제 실패
     */
    @GetMapping("/fail")
    public void fail(@PathVariable("payId") String payId) {
        log.info("kakao pay fail with payId: " + payId);
        throw new CustomException(ErrorEnum.KAKAO_PAY_FAIL);
    }

}
