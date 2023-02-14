package com.dreamtree.api.domain.progress.controller;

import com.dreamtree.api.domain.progress.dto.ProgressResDTO;
import com.dreamtree.api.domain.progress.service.ProgressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("api/progress/")
@RequiredArgsConstructor
public class ProgressController {

    private final ProgressService progressService;

    @GetMapping("{id}")
    public List<ProgressResDTO> getProgressList(@PathVariable Long id) {

        log.info("================GET PROGRESS LIST=====================");

        List<ProgressResDTO> result = progressService.getProgressList(id);
        log.info(result);

        return result;
    }
}
