package com.dreamtree.api.domain.student.dto;

import lombok.*;

import java.time.LocalDate;

/*** 임성현 ver.0.1 ***/

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentModifyDTO {

    Long studentId;

    String profileImgUrl;

    String password;

    String nickname;

    LocalDate birth;

    String gender;

}
