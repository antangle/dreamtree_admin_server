package com.dreamtree.api.domain.category.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SubCategoryListDTO {
    long subCategoryId;

    String subCategoryName;
}
