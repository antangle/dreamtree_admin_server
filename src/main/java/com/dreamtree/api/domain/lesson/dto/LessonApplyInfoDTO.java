package com.dreamtree.api.domain.lesson.dto;

import lombok.*;
//이승윤 ver0.1
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
