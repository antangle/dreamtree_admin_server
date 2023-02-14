package com.dreamtree.api.domain.parent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentInfoResDTO {

    private String email;

    private String nickname;

    private Date birth;

    private String profileImgUrl;

}
