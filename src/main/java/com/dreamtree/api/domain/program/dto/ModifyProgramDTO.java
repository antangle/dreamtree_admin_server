package com.dreamtree.api.domain.program.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModifyProgramDTO {

    Long subCategoryId;

    String title;

    String content;

    String curriculumJson;

    int times;

    int fee;
}
