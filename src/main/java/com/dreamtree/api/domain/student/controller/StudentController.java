package com.dreamtree.api.domain.student.controller;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.student.dto.*;
import com.dreamtree.api.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

/*** 임성현 ver.0.1 ***/

@RestController
@Log4j2
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("")
    public PageResponseDTO<StudentListDTO> getStudentList(StudentRequestDTO studentRequestDTO) {

        return studentService.getSearchStudentList(studentRequestDTO);
    }

    @GetMapping("/{id}")
    public StudentDetailDTO getStudentDetails(@PathVariable("id") Long id) {

        return studentService.getStudent(id);
    }

    @PostMapping("/form")
    public void postStudentForm(@RequestBody StudentAddDTO studentAddDTO) {

        studentService.addStudent(studentAddDTO);
    }

    @PostMapping("/file")
    public void postStudentFileForm(@RequestBody StudentAddFileDTO studentAddFileDTO) {

        studentService.addStudentFile(studentAddFileDTO);
    }

    @GetMapping("/college/{id}")
    public StudentCollegeDTO getStudentCollegeDetails(@PathVariable("id") Long id) {

        return studentService.getStudentCollege(id);
    }

    @PutMapping("/{id}")
    public void removeStudent(@PathVariable("id") Long id) {

        studentService.removeStudent(id);
    }

    @PutMapping("/modify")
    public void modifyStudent(@RequestBody StudentModifyDTO studentModifyDTO) {

        studentService.modifyStudent(studentModifyDTO);
    }

    @PutMapping("/state")
    public void modifyStudentAuthState(@RequestParam("id") Long id,
                                       @RequestParam("authState") String authState) {

        studentService.modifyStudentAuthState(id, authState);
    }

    @GetMapping("/college")
    public PageResponseDTO<StudentAuthRequestDTO> getCollegeAuthLists(StudentRequestDTO studentRequestDTO) {

        return studentService.getSearchCollegeAuthRequestList(studentRequestDTO);
    }

    @GetMapping("/certificate")
    public PageResponseDTO<StudentAuthRequestDTO> getCertificateAuthLists(StudentRequestDTO studentRequestDTO) {

        return studentService.getSearchCertificateAuthRequestList(studentRequestDTO);
    }

}
