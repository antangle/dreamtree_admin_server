package com.dreamtree.api.domain.report.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddReportDTO {

    String reporterEmail;

    String title;

    String content;
}
