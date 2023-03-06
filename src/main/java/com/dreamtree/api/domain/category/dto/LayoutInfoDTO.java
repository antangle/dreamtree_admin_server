package com.dreamtree.api.domain.category.dto;

import lombok.*;

import java.util.List;
//이승윤 ver0.1
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LayoutInfoDTO {
    List<CategoryListDTO> categories;
}
