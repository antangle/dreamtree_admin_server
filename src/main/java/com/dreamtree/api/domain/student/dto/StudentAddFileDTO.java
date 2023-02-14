package com.dreamtree.api.domain.student.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentAddFileDTO {

    Long student_id;

    // 인증 파일 url
    String auth_url;

    String college;

    String major;

    // 인증 이미지 url;
    String url;
}
