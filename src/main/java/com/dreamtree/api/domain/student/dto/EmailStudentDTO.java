package com.dreamtree.api.domain.student.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailStudentDTO {

    Long studentId;

    String profileImgUrl;

    String nickname;

    String role;
}
