package com.dreamtree.api.domain.program.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgressDTO {

    Long progressId;

    String state;

    String childName;

    String childGender;

    String childGrade;
}
