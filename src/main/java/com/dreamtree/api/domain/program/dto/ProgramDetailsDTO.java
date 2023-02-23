package com.dreamtree.api.domain.program.dto;

import com.dreamtree.api.domain.lesson.dto.LessonListDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgramDetailsDTO {

    //프로그램

    String title;

    String content;

    String curriculumJson;

    List<String> fileUrls;

    //학생
    String profileImgUrl;

    String nickname;

    String email;

    String college;

    String major;

    List<String> certificateNames;

    //레슨
    List<LessonListDTO> lessonLists;


}
