package com.dreamtree.api.domain.progress.service;

import com.dreamtree.api.common.enums.ErrorEnum;
import com.dreamtree.api.domain.progress.dto.PostProgressReqDTO;
import com.dreamtree.api.domain.progress.dto.ProgressResDTO;
import com.dreamtree.api.domain.progress.mapper.ProgressMapper;
import com.dreamtree.api.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** 최서연 ver.0.1 **/
@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class ProgressServiceImpl implements ProgressService {

    private final ProgressMapper progressMapper;

    @Override
    public int postProgress(PostProgressReqDTO postProgressReqDTO) {
        int count = progressMapper.postProgress(postProgressReqDTO);
        if(count != 1) throw new CustomException(ErrorEnum.POST_PROGRESS_FAILED);
        return count;
    }

    @Override
    public List<ProgressResDTO> getProgressList(Long id) {

        List<ProgressResDTO> result = progressMapper.getProgressList(id);

        return result;
    }
}
