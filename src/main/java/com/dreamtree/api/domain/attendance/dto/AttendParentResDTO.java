package com.dreamtree.api.domain.attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 최서연 ver.0.1 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendParentResDTO {

    private String title;

    private String childName;

    private String status;

    private int times;

}
