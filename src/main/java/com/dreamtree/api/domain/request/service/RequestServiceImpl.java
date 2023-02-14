package com.dreamtree.api.domain.request.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.request.dto.RequestAddDTO;
import com.dreamtree.api.domain.request.dto.RequestModDTO;
import com.dreamtree.api.domain.request.dto.RequestReqDTO;
import com.dreamtree.api.domain.request.dto.RequestResDTO;
import com.dreamtree.api.domain.request.mapper.RequestMapper;
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
public class RequestServiceImpl implements RequestService {

    private final RequestMapper requestMapper;

    @Override
    public void addRequest(RequestAddDTO addDTO) {

        requestMapper.addRequest(addDTO);

    }

    @Override
    public PageResponseDTO<RequestResDTO> getAllRequests(RequestReqDTO reqDTO) {

        List<RequestResDTO> list = requestMapper.getAllRequests(reqDTO);

        int count = requestMapper.getAllRequestsCount();

        PageResponseDTO<RequestResDTO> result = PageResponseDTO.<RequestResDTO>withAll()
                .pageRequestDTO(reqDTO)
                .dtoList(list)
                .total(count)
                .build();

        return result;

    }

    @Override
    public RequestResDTO getOneRequest(Long id) {

        RequestResDTO result = requestMapper.getOneRequest(id);

        return result;
    }

    @Override
    public void updateRequest(RequestModDTO modDTO) {

        requestMapper.updateRequest(modDTO);

    }

    @Override
    public void softDeleteRequest(Long id) {

        requestMapper.softDeleteRequest(id);

    }
}
