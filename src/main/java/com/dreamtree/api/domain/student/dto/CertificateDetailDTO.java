package com.dreamtree.api.domain.student.dto;

import lombok.*;

/*** 임성현 ver.0.1 ***/

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDetailDTO {

    String name;

    String aquireDate;

    String url;
}
