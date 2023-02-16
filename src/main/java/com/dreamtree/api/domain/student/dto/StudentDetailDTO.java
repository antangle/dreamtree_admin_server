package com.dreamtree.api.domain.student.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/*** 임성현 ver.0.1 ***/

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDetailDTO {

    String profileImgUrl;

    String role;

    String authState;

    String email;

    String nickname;

    String password;

    LocalDate birth;

    String gender;

    String authUrl;

    String college;

    String major;

    String url;

    LocalDateTime updatedAt;

    List<StudentCertificateListDTO> certificateList;
}
