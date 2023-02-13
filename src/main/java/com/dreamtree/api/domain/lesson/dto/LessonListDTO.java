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

    int day;

    LocalDate startDate;

    LocalDate endDate;

    int personnel;

    int lessonLength;

    int lessonTime;

}
