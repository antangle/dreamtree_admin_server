package com.dreamtree.api.domain.program.dto;

import com.dreamtree.api.domain.program.dto.ProgressDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonProgressDTO {

    Long lessonId;

    LocalDate startDate;

    LocalDate endDate;

    LocalDate expireStartDate;

    LocalDate expireEndDate;

    String day;

    int personnel;

    int lessonLength;

    int lessonTime;

    int fee;

    String place;

    List<ProgressDTO> progressList;
}
