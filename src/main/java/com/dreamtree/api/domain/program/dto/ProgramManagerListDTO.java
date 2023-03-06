package com.dreamtree.api.domain.program.dto;

import lombok.*;

import java.util.List;

/*** 임성현 ver.0.1 ***/

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgramManagerListDTO {

    Long programId;

    Long subCategoryId;

    String title;

    String content;

    String curriculumJson;

    String times;

    int fee;

    List<FileDTO> fileList;
}
