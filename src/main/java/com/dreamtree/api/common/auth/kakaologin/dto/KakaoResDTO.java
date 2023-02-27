package com.dreamtree.api.common.auth.kakaologin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KakaoResDTO {

    private String memberValue;

    private Long id = 0L;

    private String nickname;

    private String profileImgUrl;

    private String thumbnailImgUrl;

    private String authState;

}
