package com.dreamtree.api.domain.student.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentAddDTO {

    String profile_img_url;

    String email;

    String password;

    String nickname;

    LocalDate birth;

    String gender;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
