package com.dreamtree.api.domain.program.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileFormDTO {

    String url;

    String name;

    long size;

    String contentType;


}
