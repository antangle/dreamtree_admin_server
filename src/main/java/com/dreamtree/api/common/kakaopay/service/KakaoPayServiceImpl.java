package com.dreamtree.api.common.kakaopay.service;

import com.dreamtree.api.common.kakaopay.dto.*;
import com.dreamtree.api.common.kakaopay.mapper.PayMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class KakaoPayServiceImpl implements KakaoPayService{

    private final PayMapper payMapper;

    @Value("${kakao.pay.admin.key}")
    String adminKey;

    @Value("${kakao.pay.cid}")
    String cid;
    @Override
    public KakaoReadyResponseDTO kakaoPayReady(KakaoReadyRequestDTO kakaoReadyRequestDTO) {

        log.info("================1================");
        AfterKakaoPayReadyDTO kakaoPayReadyDTO = AfterKakaoPayReadyDTO.builder()
                .progressId(kakaoReadyRequestDTO.getProgressId())
                .memberRole(kakaoReadyRequestDTO.getRole())
                .memberId(kakaoReadyRequestDTO.getId())
                .totalAmount(kakaoReadyRequestDTO.getTotalAmount())
                .itemName(kakaoReadyRequestDTO.getItemName())
                .build();

        log.info(kakaoPayReadyDTO);
        /*기본내역 저장 및 주문번호 가져오기*/
        payMapper.insertPay(kakaoPayReadyDTO);

        log.info("=================2===============");

        Long orderId = kakaoPayReadyDTO.getPayId();
        String member = kakaoReadyRequestDTO.getId() + "," + kakaoReadyRequestDTO.getRole();

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("partner_order_id", orderId.toString());
        parameters.add("partner_user_id", member);
        parameters.add("item_name", kakaoReadyRequestDTO.getItemName());
        parameters.add("quantity", kakaoReadyRequestDTO.getQuantity().toString());
        parameters.add("total_amount", kakaoReadyRequestDTO.getTotalAmount().toString());
        parameters.add("vat_amount", "0");
        parameters.add("tax_free_amount", kakaoReadyRequestDTO.getTaxFreeAmount().toString());
        parameters.add("approval_url", "http://localhost:3000/payment/success/" + orderId); // 성공 시 redirect url
        parameters.add("cancel_url", "http://localhost:3000/payment/cancel/" + orderId); // 취소 시 redirect url
        parameters.add("fail_url", "http://localhost:3000/payment/fail/" + orderId); // 실패 시 redirect url

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(parameters, this.getHeaders());

        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        KakaoReadyResponseDTO kakaoReady = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/ready",
                body,
                KakaoReadyResponseDTO.class
        );

        payMapper.updateTid(kakaoReady.getTid());

        return kakaoReady;
    }

    @Override
    public KakaoApproveResponseDTO approveResponse(KakaoPayApproveDTO kakaoPayApproveDTO) {
        // 카카오 요청
        PayDTO paymentInfo = payMapper.getPaymentInfo(kakaoPayApproveDTO.getPayId());

        String member = paymentInfo.getMemberId() + "," + paymentInfo.getMemberRole();


        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", paymentInfo.getTid());
        parameters.add("partner_order_id", kakaoPayApproveDTO.getPayId().toString());
        parameters.add("partner_user_id", member);
        parameters.add("pg_token", kakaoPayApproveDTO.getPgToken());

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(parameters, this.getHeaders());

        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        KakaoApproveResponseDTO approveResponse = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/approve",
                body,
                KakaoApproveResponseDTO.class);

        return approveResponse;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        String auth = "KakaoAK " + adminKey;

        httpHeaders.set("Authorization", auth);
        httpHeaders.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        return httpHeaders;
    }
}
