package com.dreamtree.api.domain.student.dto;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    Long student_id;

    String profile_img_url;

    String role;

    // 대학생 인증 유무 상태 값 ( no, yes, pending )
    String auth_state;

    String email;

    String password;

    String nickname;

    LocalDate birth;

    String gender;

    // 인증 파일 url
    String auth_url;

    String college;

    String major;

    // 인증 이미지 url;
    String url;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    LocalDateTime deletedAt;
}
