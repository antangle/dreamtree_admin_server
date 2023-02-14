package com.dreamtree.api.domain.request.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.request.dto.RequestAddDTO;
import com.dreamtree.api.domain.request.dto.RequestModDTO;
import com.dreamtree.api.domain.request.dto.RequestReqDTO;
import com.dreamtree.api.domain.request.dto.RequestResDTO;

import java.util.List;

/** 최서연 ver.0.1 **/
public interface RequestService {

    int addRequest(RequestAddDTO addDTO);

    PageResponseDTO<RequestResDTO> getAllRequests(RequestReqDTO reqDTO);

    RequestResDTO getOneRequest(Long id);

    int updateRequest(RequestModDTO modDTO);

    int softDeleteRequest(Long id);

}
