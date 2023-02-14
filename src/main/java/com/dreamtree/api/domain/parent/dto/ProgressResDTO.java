package com.dreamtree.api.domain.parent.dto;

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

    private String child_name;

    private String state;

    private String subCategory;

    private String title;

    private Date start_date;

    private Date end_date;

    private Date expiration_date;

    private String place;

    private int fee;

    private int length;

    private int time;

}
