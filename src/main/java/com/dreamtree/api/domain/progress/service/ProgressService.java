package com.dreamtree.api.domain.progress.service;

import com.dreamtree.api.domain.progress.dto.ProgressResDTO;

import java.util.List;

public interface ProgressService {

    List<ProgressResDTO> getProgressList(Long id);

}
