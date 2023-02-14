package com.dreamtree.api.domain.progress.mapper;

import com.dreamtree.api.domain.progress.dto.ProgressResDTO;

import java.util.List;

public interface ProgressMapper {

    List<ProgressResDTO> getProgressList(Long id);

}
