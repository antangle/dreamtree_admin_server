package com.dreamtree.api.domain.parent.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoReqDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoResDTO;
import com.dreamtree.api.domain.parent.dto.ParentModDTO;

public interface ParentService {

    PageResponseDTO<ParentInfoResDTO> getAllParentsList(ParentInfoReqDTO reqDTO);

    ParentInfoResDTO getOneParentInfo(Long id);

    void updateParentInfo(ParentModDTO modDTO);

    void softDeleteOneParent(Long id);
}
