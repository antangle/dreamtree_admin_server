package com.dreamtree.api.domain.student.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*** 최서연 ver.0.1 ***/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentKakaoAddDTO {

    String email;

    String nickname;

    String profileImgUrl;

    String thumbnailImgUrl;

    String birthday;

}
