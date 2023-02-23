package com.dreamtree.api.domain.report.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReportListDTO {

    Long reportId;

    String reporterEmail;

    String title;

    String status;

    String updatedAt;
}
