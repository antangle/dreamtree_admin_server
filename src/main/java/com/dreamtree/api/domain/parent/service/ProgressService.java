package com.dreamtree.api.domain.parent.service;

import com.dreamtree.api.domain.parent.dto.ProgressResDTO;

import java.util.List;

public interface ProgressService {

    List<ProgressResDTO> getProgressList(Long id);

}
