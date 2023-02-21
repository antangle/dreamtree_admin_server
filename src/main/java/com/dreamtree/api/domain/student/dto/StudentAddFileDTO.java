package com.dreamtree.api.domain.student.dto;

import lombok.*;

/*** 임성현 ver.0.1 ***/

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentAddFileDTO {

    Long studentId;

    String college;

    String major;

    // 인증 이미지 url;
    String url;
}
