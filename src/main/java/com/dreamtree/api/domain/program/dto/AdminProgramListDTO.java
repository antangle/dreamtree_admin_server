package com.dreamtree.api.domain.program.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminProgramListDTO {

    Long programId;

    Long subCategoryId;

    String title;

    String content;

    String curriculumJson;

    String times;

    Long studentId;

    String nickname;

    String email;

    String authState;

    List<FileDTO> fileList;
}
