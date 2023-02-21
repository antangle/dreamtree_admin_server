package com.dreamtree.api.domain.attendance.dto;

import lombok.*;
import org.checkerframework.checker.units.qual.A;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendModReqDTO {

    private Long attendanceId;

    private String status;

}
