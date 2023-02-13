package com.dreamtree.api.domain.student.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentModifyDTO {

    Long student_id;

    String profile_img_url;

    String password;

    String nickname;

    LocalDate birth;

    String gender;

}
