package com.dreamtree.api.domain.progress.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgressResDTO {

    private String childName;

    private String state;

    private String subCategory;

    private String title;

    private Date startDate;

    private Date endDate;

    private Date expirationDate;

    private String place;

    private int fee;

    private int length;

    private int time;

}
