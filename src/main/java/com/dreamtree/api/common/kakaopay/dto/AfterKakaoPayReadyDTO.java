package com.dreamtree.api.common.kakaopay.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AfterKakaoPayReadyDTO {
    Long payId;

    Long memberId;

    String memberRole;

    Integer totalAmount;

    String itemName;



}
