package com.dreamtree.api.common.kakaopay.dto;

import lombok.*;

/** 이승윤 ver.0.1 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayDTO {
    String tid;

    Long progressId;

    String memberRole;

    Long memberId;

}
