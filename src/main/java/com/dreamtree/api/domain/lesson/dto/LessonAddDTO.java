package com.dreamtree.api.domain.lesson.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonAddDTO {

    long programId;

    long subCategoryId;

    LocalDate startDate;

    LocalDate endDate;

    LocalDate expireStartDate;

    LocalDate expireEndDate;

    int day;

    int personnel;

    int lessonLength;

    int lessonTime;

    int fee;

    String place;
}
