package com.dreamtree.api.domain.request.mapper;

import com.dreamtree.api.domain.request.dto.RequestAddDTO;
import com.dreamtree.api.domain.request.dto.RequestReqDTO;
import com.dreamtree.api.domain.request.dto.RequestResDTO;

import java.util.List;

public interface RequestMapper {

    void addRequest(RequestAddDTO addDTO);

    List<RequestResDTO> getAllRequests(RequestReqDTO reqDTO);

    RequestResDTO getOneRequest(Long id);

    int getAllRequestsCount();

}
