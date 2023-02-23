package com.dreamtree.api.domain.report.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {

    Long reportId;

    String reporterEmail;

    String title;

    String content;

    String status;

    String updatedAt;
}
