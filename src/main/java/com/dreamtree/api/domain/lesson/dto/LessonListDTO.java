package com.dreamtree.api.domain.lesson.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
//이승윤 ver0.1
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonListDTO {

    Long lessonId;
    LocalDate startDate;

    LocalDate endDate;

    LocalDate expireStartDate;

    LocalDate expireEndDate;

    String day;

    int personnel;

    int lessonLength;

    int lessonTime;

    int fee;

    String place;

    List<Long> progressList;
}
