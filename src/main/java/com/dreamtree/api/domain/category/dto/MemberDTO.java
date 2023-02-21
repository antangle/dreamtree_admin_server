package com.dreamtree.api.domain.category.dto;

import lombok.*;

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
