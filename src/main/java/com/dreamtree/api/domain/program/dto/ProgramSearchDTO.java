package com.dreamtree.api.domain.program.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProgramSearchDTO {
    String keyword;

    List<String> condition;

    String order;

    long subCategoryId;

}
