package com.dreamtree.api.domain.parent.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.parent.dto.EmailParentDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoReqDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoResDTO;
import com.dreamtree.api.domain.parent.dto.ParentModDTO;

/** 최서연 ver.0.2 **/
public interface ParentService {

    PageResponseDTO<ParentInfoResDTO> getAllParentsList(ParentInfoReqDTO reqDTO);

    ParentInfoResDTO getOneParentInfo(Long id);

    int updateParentInfo(ParentModDTO modDTO);

    int softDeleteOneParent(Long id);

    EmailParentDTO getEmailParent(String email);
}
