package com.dreamtree.api.common.kakaopay.dto;

import lombok.*;

/** 이승윤 ver.0.1 **/

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AfterKakaoPayReadyDTO {
    Long payId;

    Long progressId;

    Long memberId;

    String memberRole;

    Integer totalAmount;

    String itemName;



}
