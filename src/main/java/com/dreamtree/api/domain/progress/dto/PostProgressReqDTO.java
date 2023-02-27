package com.dreamtree.api.domain.progress.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PostProgressReqDTO {
    private Long parentId;
    private Long lessonId;
    private String childName;
    private String childGender;
    private String childGrade;
}
