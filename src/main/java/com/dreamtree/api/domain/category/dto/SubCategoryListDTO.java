package com.dreamtree.api.domain.category.dto;

import lombok.*;
//이승윤 ver0.1
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
