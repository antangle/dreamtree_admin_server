package com.dreamtree.api.domain.student.dto;

import lombok.*;

/*** 임성현 ver.0.1 ***/

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCertificateListDTO {

    Long certificateId;

    String name;

    String url;

    String aquireDate;

    String authState;
}
