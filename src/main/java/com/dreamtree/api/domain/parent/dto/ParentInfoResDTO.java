package com.dreamtree.api.domain.parent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/** 최서연 ver.0.1 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ParentInfoResDTO {

    private String email;

    private String nickname;

    private Date birth;

    private String profileImgUrl;

}
