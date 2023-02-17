package com.dreamtree.api.domain.program.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgramFormDTO {

    long programId;

    long studentId;

    long subCategoryId;

    String title;

    String content;

    String curriculumJson;

    int times;

    int fee;

    List<String> fileForms;
}
