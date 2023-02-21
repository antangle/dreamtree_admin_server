package com.dreamtree.api.common.auth.kakaologin.dto;

import lombok.Data;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Data
public class KakaoUserInfoDTO {

    private Long id;

    private String profile_nickname;

    private KakaoPropertyDTO propertyDTO;

}
