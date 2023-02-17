package com.dreamtree.api.domain.request.controller;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.request.dto.RequestAddDTO;
import com.dreamtree.api.domain.request.dto.RequestModDTO;
import com.dreamtree.api.domain.request.dto.RequestReqDTO;
import com.dreamtree.api.domain.request.dto.RequestResDTO;
import com.dreamtree.api.domain.request.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

/** 최서연 ver.0.1 **/
@RestController
@Log4j2
@RequestMapping("api/request/")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;
    @PostMapping("")
    public RequestAddDTO addRequest(@RequestBody RequestAddDTO addDTO) {

        log.info("=================ADD REQUEST==================");

        requestService.addRequest(addDTO);
        log.info(addDTO);
        return addDTO;
    }

    @GetMapping("list")
    public PageResponseDTO<RequestResDTO> getAllRequests(RequestReqDTO reqDTO) {

        log.info("=================GET ALL REQUESTS==================");

        PageResponseDTO<RequestResDTO> result = requestService.getAllRequests(reqDTO);

        return result;
    }

    @GetMapping("list/{id}")
    public RequestResDTO getOneRequest(@PathVariable Long id) {

        log.info("=================GET ONE REQUEST==================");

        RequestResDTO result = requestService.getOneRequest(id);

        log.info(result);

        return result;
    }

    @PutMapping("modify")
    public RequestModDTO updateRequest(@RequestBody RequestModDTO modDTO) {

        log.info("=================UPDATE REQUEST==================");

        requestService.updateRequest(modDTO);
        return modDTO;
    }

    @DeleteMapping("delete/{id}")
    public Long softDeleteRequest(@PathVariable Long id) {

        log.info("==============DELETE REQUEST=====================");

        requestService.softDeleteRequest(id);
        return id;

    }

}
