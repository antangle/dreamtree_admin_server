package com.dreamtree.api.domain.parent.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailParentDTO {

    Long parentId;

    String nickname;

    String role;

    String profileImgUrl;
}
