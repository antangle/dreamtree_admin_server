package com.dreamtree.api.domain.attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendModReqDTO {

    private Long attendanceId;

    private String status;

}
