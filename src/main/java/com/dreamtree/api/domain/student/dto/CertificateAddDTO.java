package com.dreamtree.api.domain.student.dto;

import lombok.*;

import java.time.LocalDate;

/*** 임성현 ver.0.1 ***/

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CertificateAddDTO {

    Long studentId;

    String url;

    String name;

    LocalDate aquireDate;
}
