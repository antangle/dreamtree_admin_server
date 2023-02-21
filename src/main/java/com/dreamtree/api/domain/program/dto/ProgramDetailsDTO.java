package com.dreamtree.api.domain.program.dto;

import com.dreamtree.api.domain.lesson.dto.LessonListDTO;
import com.dreamtree.api.domain.student.dto.StudentDTO;
import com.dreamtree.api.domain.student.dto.StudentDetailDTO;
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
