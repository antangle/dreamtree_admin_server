package com.dreamtree.api.common.kakaopay.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KakaoReadyRequestDTO {
    String itemName;

    Long id;

    String role;

    Integer quantity;

    Integer totalAmount;

    Integer taxFreeAmount;
}
