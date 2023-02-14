package com.dreamtree.api.domain.request.dto;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 최서연 ver.0.1 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestAddDTO {

    @JsonProperty("id")
    private Long request_id;

    private String title;

    private Long parent_id;

    private int sub_category_id;

    private String description;

    private String content;

    private String student_grade;

    private String student_gender;

}
