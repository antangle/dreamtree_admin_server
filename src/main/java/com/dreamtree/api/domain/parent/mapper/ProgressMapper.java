package com.dreamtree.api.domain.parent.mapper;

import com.dreamtree.api.domain.parent.dto.ProgressResDTO;

import java.util.List;

public interface ProgressMapper {

    List<ProgressResDTO> getProgressList(Long id);

}
