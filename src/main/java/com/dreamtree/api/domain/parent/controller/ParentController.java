package com.dreamtree.api.domain.parent.controller;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoReqDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoResDTO;
import com.dreamtree.api.domain.parent.dto.ParentModDTO;
import com.dreamtree.api.domain.parent.service.ParentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public ParentInfoResDTO getOneParentInfo(@PathVariable Long id) {

        log.info("================GET ONE PARENT INFO=====================");

        ParentInfoResDTO result = parentService.getOneParentInfo(id);
        return result;
    }

    @PutMapping("")
    public ParentModDTO updateParentInfo(@RequestBody ParentModDTO modDTO) {

        log.info("================UPDATE PARENT INFO=====================");
        parentService.updateParentInfo(modDTO);
        log.info(modDTO);
        return modDTO;
    }

    @PutMapping("/delete/{id}")
    public Long softDeleteOneParent(@PathVariable Long id) {

        parentService.softDeleteOneParent(id);
        return id;

    }

}
