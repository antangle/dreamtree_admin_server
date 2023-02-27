package com.dreamtree.api.common.kakaopay.dto;

import lombok.*;

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
