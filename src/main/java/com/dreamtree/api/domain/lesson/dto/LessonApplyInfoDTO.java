package com.dreamtree.api.domain.lesson.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonApplyInfoDTO {
    String title;

    String email;

    Long subCategoryId;

    Long programId;

}
