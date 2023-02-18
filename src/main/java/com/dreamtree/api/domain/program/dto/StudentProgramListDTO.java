package com.dreamtree.api.domain.program.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentProgramListDTO {
    long programId;

    String title;
}
