package com.dreamtree.api.domain.program.dto;

import com.dreamtree.api.domain.lesson.dto.LessonListDTO;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgramDetailsDTO {

    String curriculumJson;

    String title;

    String content;

    List<String> fileUrls;

    String profileImgUrl;

    String nickname;

    String email;

    List<LessonListDTO> lessonLists;
    List<String> certificateNames;


}
