package com.dreamtree.api.domain.program.controller;

import com.dreamtree.api.domain.program.dto.ProgramDetailsDTO;
import com.dreamtree.api.domain.program.dto.ProgramListDTO;
import com.dreamtree.api.domain.program.dto.ProgramSearchDTO;
import com.dreamtree.api.domain.program.service.ProgramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("api/programs")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;

    @GetMapping("/")
    public List<ProgramListDTO> getProgramLists(
            @RequestParam("searchDTO") ProgramSearchDTO programSearchDTO){
        return programService.getProgramLists(programSearchDTO);
    }

    @GetMapping("/details/{id}")
    public ProgramDetailsDTO getProgramDetails(@PathVariable("id") Long id){
        return programService.getProgramDetailsById(id);
    }
}
