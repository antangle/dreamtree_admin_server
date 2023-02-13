package com.dreamtree.api.domain.parent.controller;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoReqDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoResDTO;
import com.dreamtree.api.domain.parent.service.ParentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("api/parent/")
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;

    @GetMapping("list")
    public PageResponseDTO<ParentInfoResDTO> getParentList(ParentInfoReqDTO reqDTO) {

        log.info("================GET ALL PARENTS LIST=====================");

        PageResponseDTO<ParentInfoResDTO> result = parentService.getAllParentsList(reqDTO);
        return result;
    }

}
