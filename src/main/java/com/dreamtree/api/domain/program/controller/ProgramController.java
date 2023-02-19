package com.dreamtree.api.domain.program.controller;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.program.dto.*;
import com.dreamtree.api.domain.program.service.ProgramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//이승윤 ver0.1
@RestController
@Log4j2
@RequestMapping("api/program")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;
    @GetMapping("/")
    public PageResponseDTO<ProgramListDTO> getProgramLists(ProgramSearchDTO programSearchDTO){
        log.info(programSearchDTO);
        return programService.getProgramLists(programSearchDTO);
    }

    @GetMapping("/student")
    public List<ProgramListDTO> getProgramListsByStudentId(@RequestParam Long studentId){
        return programService.getProgramListsByStudentId(studentId);
    }

    @GetMapping("/wordcloud")
    public List<WordCloudDTO> getWordCloudInfo(){
        return programService.getWordCloudInfo();
    }

    @GetMapping("/details/{id}")
    public ProgramDetailsDTO getProgramDetails(@PathVariable("id") Long programId){
        return programService.getProgramDetailsById(programId);
    }

    @PostMapping("/form")
    public long postProgramForm(@RequestBody ProgramFormDTO programFormDTO){
        log.info(programFormDTO);
        return programService.postProgramForm(programFormDTO);
    }


}
