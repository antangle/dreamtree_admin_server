package com.dreamtree.api.domain.lesson.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonListDTO {


    LocalDate startDate;

    LocalDate endDate;

    String day;

    int personnel;

    int lessonLength;

    int lessonTime;

}
