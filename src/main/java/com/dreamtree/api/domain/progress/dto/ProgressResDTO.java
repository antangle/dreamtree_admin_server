package com.dreamtree.api.domain.progress.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/** 최서연 ver.0.1 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgressResDTO {

    private String childName;

    private String payStatus;

    private String state;

    private String subCategory;

    private String title;

    private Date startDate;

    private Date endDate;

    private Date expirationDate;

    private String place;

    private int fee;

    private int lesson_length;

    private int lesson_time;

}
