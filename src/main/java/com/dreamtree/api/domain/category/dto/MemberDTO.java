package com.dreamtree.api.domain.category.dto;

import lombok.*;
//이승윤 ver0.1
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
    String profileImgUrl;

    String nickname;

    String email;
}
