package com.dreamtree.api.domain.program.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileTypeDTO {
    String filename;

    String contentType;
}
