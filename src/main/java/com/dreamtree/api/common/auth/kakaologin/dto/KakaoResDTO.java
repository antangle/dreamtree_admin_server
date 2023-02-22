package com.dreamtree.api.common.auth.kakaologin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KakaoResDTO {

    private String memberValue = "parents";

    private Long id = 0L;

}
