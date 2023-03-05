package com.dreamtree.api.common.kakaopay.dto;

import lombok.*;

/** 이승윤 ver.0.1 **/
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KakaoReadyResponseDTO {
    private String tid; // 결제 고유 번호
    private String next_redirect_mobile_url; // 모바일 웹일 경우 받는 결제페이지 url
    private String next_redirect_pc_url; // pc 웹일 경우 받는 결제 페이지
    private String created_at;
}
