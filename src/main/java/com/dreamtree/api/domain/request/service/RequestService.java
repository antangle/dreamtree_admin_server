package com.dreamtree.api.domain.request.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.request.dto.RequestAddDTO;
import com.dreamtree.api.domain.request.dto.RequestReqDTO;
import com.dreamtree.api.domain.request.dto.RequestResDTO;

import java.util.List;

public interface RequestService {

    void addRequest(RequestAddDTO addDTO);

    PageResponseDTO<RequestResDTO> getAllRequests(RequestReqDTO reqDTO);

    RequestResDTO getOneRequest(Long id);

}
