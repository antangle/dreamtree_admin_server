package com.dreamtree.api.domain.request.mapper;

import com.dreamtree.api.domain.request.dto.RequestAddDTO;
import com.dreamtree.api.domain.request.dto.RequestModDTO;
import com.dreamtree.api.domain.request.dto.RequestReqDTO;
import com.dreamtree.api.domain.request.dto.RequestResDTO;

import java.util.List;

/** 최서연 ver.0.1 **/
public interface RequestMapper {

    void addRequest(RequestAddDTO addDTO);

    List<RequestResDTO> getAllRequests(RequestReqDTO reqDTO);

    RequestResDTO getOneRequest(Long id);

    int getAllRequestsCount();

    void updateRequest(RequestModDTO modDTO);

    void softDeleteRequest(Long id);

}
