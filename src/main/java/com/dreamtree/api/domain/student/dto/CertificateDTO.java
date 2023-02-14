package com.dreamtree.api.domain.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class CertificateDTO {

    Long certificate_id;

    Long student_id;

    String url;

    String name;

    LocalDate aquire_date;

    String auth_state;

    LocalDateTime createAt;

    LocalDateTime updateAt;

    LocalDateTime deleteAt;
}
