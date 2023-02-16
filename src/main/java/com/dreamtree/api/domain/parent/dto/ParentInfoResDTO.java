package com.dreamtree.api.domain.parent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/** 최서연 ver.0.1 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ParentInfoResDTO {

    private Long id;

    private String email;

    private String nickname;

    private String password;

    private Date birth;

    private String profileImgUrl;

}
