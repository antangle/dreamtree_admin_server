package com.dreamtree.api.domain.attendance.dto;

import lombok.*;

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
