package com.dreamtree.api.domain.program.controller;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.common.minio.service.MinioService;
import com.dreamtree.api.domain.program.dto.*;
import com.dreamtree.api.domain.program.service.ProgramService;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

//이승윤 ver0.1
@RestController
@Log4j2
@RequestMapping("api/programs")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;
    @GetMapping("/")
    public PageResponseDTO<ProgramListDTO> getProgramLists(ProgramSearchDTO programSearchDTO){
        return programService.getProgramLists(programSearchDTO);
    }

    @GetMapping("/details/{id}")
    public ProgramDetailsDTO getProgramDetails(@PathVariable("id") Long id){
        return programService.getProgramDetailsById(id);
    }

    @PostMapping("/form")
    public void postProgramForm(@RequestBody ProgramFormDTO programFormDTO){
        programService.postProgramForm(programFormDTO);
    }
}
