package com.dreamtree.api.domain.request.mapper;

import com.dreamtree.api.domain.request.dto.RequestAddDTO;
import com.dreamtree.api.domain.request.dto.RequestModDTO;
import com.dreamtree.api.domain.request.dto.RequestReqDTO;
import com.dreamtree.api.domain.request.dto.RequestResDTO;

import java.util.List;

/** 최서연 ver.0.1 **/
public interface RequestMapper {

    int addRequest(RequestAddDTO addDTO);

    List<RequestResDTO> getAllRequests(RequestReqDTO reqDTO);

    RequestResDTO getOneRequest(Long id);

    int getAllRequestsCount(RequestReqDTO reqDTO);

    int updateRequest(RequestModDTO modDTO);

    int softDeleteRequest(Long id);

}
