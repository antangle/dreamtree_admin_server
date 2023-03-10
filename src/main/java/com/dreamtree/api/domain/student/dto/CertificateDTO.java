package com.dreamtree.api.domain.student.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*** 임성현 ver.0.1 ***/

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDTO {

    Long certificateId;

    Long studentId;

    String url;

    String name;

    LocalDate aquireDate;

    String authState;

    LocalDateTime createAt;

    LocalDateTime updateAt;

    LocalDateTime deleteAt;
}
