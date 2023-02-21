package com.dreamtree.api.common.auth.kakaologin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KakaoPropertyDTO {

    private String profile_image;

    private String account_email;

    private Date birthday;
}
