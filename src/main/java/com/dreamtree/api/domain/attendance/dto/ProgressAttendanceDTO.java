package com.dreamtree.api.domain.attendance.dto;

import lombok.*;

//이승윤 ver0.1
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgressAttendanceDTO {

    long attendanceId;

    String childName;

    String attendanceStatus;
}
