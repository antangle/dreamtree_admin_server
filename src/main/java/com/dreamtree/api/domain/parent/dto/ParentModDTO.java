package com.dreamtree.api.domain.parent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 최서연 ver.0.1 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParentModDTO {
    private Long id;

    private String nickname;

    private String password;

    private String profile_img_url;

}
