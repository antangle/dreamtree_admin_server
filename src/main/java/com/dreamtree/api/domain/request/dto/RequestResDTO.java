package com.dreamtree.api.domain.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** 최서연 ver.0.1 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestResDTO {

    private Long requestId;

    private String title;

    private String nickname;

    private Long parentId;

    private String categoryName;

    private String subCategoryName;

    private String description;

    private String content;

    private String studentGrade;

    private String studentGender;

    private LocalDateTime createdAt;

}
