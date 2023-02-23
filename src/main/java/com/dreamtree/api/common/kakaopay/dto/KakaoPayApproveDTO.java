package com.dreamtree.api.common.kakaopay.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KakaoPayApproveDTO {
    String pgToken;

    Long payId;
}
