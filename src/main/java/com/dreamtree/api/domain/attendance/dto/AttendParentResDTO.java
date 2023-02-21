package com.dreamtree.api.domain.attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/** 최서연 ver.0.1 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendParentResDTO {

    String title;

    int day;

    int lessonTime;

    int lessonLength;

    LocalDate startDate;

    LocalDate endDate;

    int times;

    private String childName;

    private String attendanceStatus;

    private long attendanceId;

}
