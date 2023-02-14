package com.dreamtree.api.domain.parent.dto;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.common.dto.PageResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentInfoResDTO {

    private String email;

    private String nickname;

    private Date birth;

    private String profile_img_url;

}
