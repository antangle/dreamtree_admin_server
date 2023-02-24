package com.dreamtree.api.domain.progress.service;

import com.dreamtree.api.domain.progress.dto.PostProgressReqDTO;
import com.dreamtree.api.domain.progress.dto.ProgressResDTO;

import java.util.List;

/** 최서연 ver.0.1 **/
public interface ProgressService {

    List<ProgressResDTO> getProgressList(Long id);

    int postProgress(PostProgressReqDTO postProgressReqDTO);
}
