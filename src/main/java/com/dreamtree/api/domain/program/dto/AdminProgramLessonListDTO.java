package com.dreamtree.api.domain.program.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminProgramLessonListDTO {

    Long programId;

    String title;

    Long studentId;

    String nickname;

    String email;

    List<LessonProgressDTO> lessonProgressDTO;
}
