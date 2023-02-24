package com.dreamtree.api.domain.progress.controller;

import com.dreamtree.api.domain.progress.dto.PayStatusReqDTO;
import com.dreamtree.api.domain.progress.dto.ProgressResDTO;
import com.dreamtree.api.domain.progress.service.ProgressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** 최서연 ver.0.1 **/
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

    @PutMapping("updatePayStatus")
    public int updatePayStatus(@RequestBody PayStatusReqDTO reqDTO) {

        log.info("================UPDATE PAY STATUS================");

        int result = progressService.updatePayStatus(reqDTO);

        return result;
    }
}
