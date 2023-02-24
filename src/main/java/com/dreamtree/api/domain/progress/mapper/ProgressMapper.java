package com.dreamtree.api.domain.progress.mapper;

import com.dreamtree.api.domain.program.dto.ProgressDTO;
import com.dreamtree.api.domain.progress.dto.PostProgressReqDTO;
import com.dreamtree.api.domain.progress.dto.ProgressResDTO;

import java.util.List;

/** 최서연 ver.0.1 **/
public interface ProgressMapper {

    List<ProgressResDTO> getProgressList(Long id);

    int getProgressListCount(Long id);

    int postProgress(PostProgressReqDTO progressDTO);

}
