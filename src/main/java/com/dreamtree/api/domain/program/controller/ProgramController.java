package com.dreamtree.api.domain.program.controller;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.program.dto.*;
import com.dreamtree.api.domain.program.mapper.ProgramManagerMapper;
import com.dreamtree.api.domain.program.service.ProgramService;
import com.dreamtree.api.domain.student.dto.StudentRequestDTO;
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

    @GetMapping("/myProgram/{id}")
    public List<ProgramManagerListDTO> getMyProgram(@PathVariable("id") Long id) {

        log.info(id);

        return programService.myProgramList(id);
    }

    @GetMapping("/myLesson/{id}")
    public List<ProgramLessonDTO> getMyLesson(@PathVariable("id") Long id) {

        return programService.myLessonList(id);
    }

    @GetMapping("/adminProgram")
    public PageResponseDTO<AdminProgramListDTO> getAdminProgramList(StudentRequestDTO studentRequestDTO) {

        return programService.adminProgramList(studentRequestDTO);
    }

    @GetMapping("/adminLesson")
    public PageResponseDTO<AdminProgramLessonListDTO> getAdminLessonList(StudentRequestDTO studentRequestDTO) {

        return programService.adminProgramLessonList(studentRequestDTO);
    }

    @PutMapping("removeProgram/{id}")
    public void removeProgram(@PathVariable("id") Long id) {

        programService.removeProgram(id);
    }

    @PutMapping("removeLesson/{id}")
    public void removeLesson(@PathVariable("id") Long id) {

        programService.removeLesson(id);
    }

    @PutMapping("modifyProgram")
    public void modifyProgram(@RequestBody ModifyProgramDTO modifyProgramDTO) {

        log.info("modify: " + modifyProgramDTO);

        programService.modifyProgram(modifyProgramDTO);
    }

    @GetMapping("count/{id}")
    public int getProgramLessonCount(@PathVariable("id") Long id) {

        return programService.selectProgramLessonCount(id);
    }
}
