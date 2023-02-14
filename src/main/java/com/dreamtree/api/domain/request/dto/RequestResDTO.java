package com.dreamtree.api.domain.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestResDTO {

    private String title;

    private String nickname;

    private String categoryName;

    private String subCategoryName;

    private String description;

    private String content;

    private String studentGrade;

    private String studentGender;

}
