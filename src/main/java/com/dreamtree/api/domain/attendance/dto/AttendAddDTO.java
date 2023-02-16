package com.dreamtree.api.domain.attendance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/** 최서연 ver.0.1 **/
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
