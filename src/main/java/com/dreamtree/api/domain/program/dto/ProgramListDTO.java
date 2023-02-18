package com.dreamtree.api.domain.program.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgramListDTO {

    long programId;

    long subCategoryId;

    String title;

    int times;

    String profileImgUrl;
}
