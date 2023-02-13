package com.dreamtree.api.domain.parent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentModDTO {

    private String nickname;

    private String password;

    private String profile_img_url;

}
