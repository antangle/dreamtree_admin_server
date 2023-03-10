package com.dreamtree.api.domain.student.dto;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*** 임성현 ver.0.1 ***/

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    Long studentId;

    String profileImgUrl;

    String role;

    // 대학생 인증 유무 상태 값 ( no, yes, pending )
    String authState;

    String email;

    String password;

    String nickname;

    LocalDate birth;

    String gender;

    // 인증 파일 url
    String authUrl;

    String college;

    String major;

    // 인증 이미지 url;
    String url;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    LocalDateTime deletedAt;
}
