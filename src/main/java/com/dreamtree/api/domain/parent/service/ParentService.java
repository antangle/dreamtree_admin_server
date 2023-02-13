package com.dreamtree.api.domain.parent.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoReqDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoResDTO;

public interface ParentService {

    PageResponseDTO<ParentInfoResDTO> getAllParentsList(ParentInfoReqDTO reqDTO);

}
