package com.dreamtree.api.domain.parent.mapper;

import com.dreamtree.api.domain.parent.dto.ParentInfoReqDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoResDTO;

import java.util.List;

public interface ParentMapper {

    List<ParentInfoResDTO> getParentList(ParentInfoReqDTO reqDTO);

    int getCount(ParentInfoReqDTO reqDTO);

}
