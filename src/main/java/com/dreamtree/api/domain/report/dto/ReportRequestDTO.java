package com.dreamtree.api.domain.report.dto;

import com.dreamtree.api.common.dto.PageRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequestDTO extends PageRequestDTO {

    String reporterEmail;

    String sort;
}
