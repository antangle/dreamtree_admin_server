package com.dreamtree.api.domain.attendance.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendStudentResDTO {
    String title;

    int day;

    int lessonTime;

    int lessonLength;

    LocalDate startDate;

    LocalDate endDate;

    int times;

    List<ProgressAttendanceDTO> progressList;
}