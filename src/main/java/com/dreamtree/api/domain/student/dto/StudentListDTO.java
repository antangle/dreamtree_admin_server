package com.dreamtree.api.domain.student.dto;

import lombok.Builder;
import lombok.Data;

/*** 임성현 ver.0.1 ***/

@Data
@Builder
public class StudentListDTO {

    Long studentId;

    String nickname;

    String email;

    String authState;

}
