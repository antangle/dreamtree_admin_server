package com.dreamtree.api.domain.program.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WordCloudDTO {
    long subCategoryId;

    String subCategoryName;

    int count;
}
