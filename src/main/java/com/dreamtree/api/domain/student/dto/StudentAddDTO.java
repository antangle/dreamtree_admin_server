package com.dreamtree.api.domain.student.dto;

import lombok.*;

import java.time.LocalDate;

/*** 임성현 ver.0.1 ***/

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentAddDTO {

    String profileImgUrl;

    String email;

    String password;

    String nickname;

    LocalDate birth;

    String gender;

}
