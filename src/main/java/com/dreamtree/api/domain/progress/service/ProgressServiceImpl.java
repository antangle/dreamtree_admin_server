package com.dreamtree.api.domain.progress.service;


import com.dreamtree.api.domain.progress.dto.ProgressResDTO;
import com.dreamtree.api.domain.progress.mapper.ProgressMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class ProgressServiceImpl implements ProgressService {

    private final ProgressMapper progressMapper;
    @Override
    public List<ProgressResDTO> getProgressList(Long id) {

        List<ProgressResDTO> result = progressMapper.getProgressList(id);

        return result;
    }
}
