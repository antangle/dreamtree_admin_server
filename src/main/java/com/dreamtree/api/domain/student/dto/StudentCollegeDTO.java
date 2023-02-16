package com.dreamtree.api.domain.student.dto;

import lombok.*;

/*** 임성현 ver.0.1 ***/

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentCollegeDTO {

    String auth_url;
    String college;

    String major;

    String url;
}
