package com.dreamtree.api.domain.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestModDTO {

    private Long id;
    private String title;

    private Long subCategoryId;

    private String description;

    private String content;

    private String studentGrade;

    private String studentGender;

}
