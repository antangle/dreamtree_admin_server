package com.dreamtree.api.domain.attendance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttendAddDTO {

    @JsonProperty("id")
    Long attendanceId;

    Long progressId;
    
    String status;

    int times;

}
