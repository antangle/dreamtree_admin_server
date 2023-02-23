package com.dreamtree.api.domain.category.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LayoutInfoDTO {
    List<CategoryListDTO> categories;
}
