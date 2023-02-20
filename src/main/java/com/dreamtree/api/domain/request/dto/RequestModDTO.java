package com.dreamtree.api.domain.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 최서연 ver.0.1 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestModDTO {

    private Long requestId;
    private String title;

    private Long sub_category_id;

    private String description;

    private String content;

    private String student_grade;

    private String student_gender;

}
