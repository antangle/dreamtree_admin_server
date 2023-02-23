package com.dreamtree.api.domain.program.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.program.dto.*;
import com.dreamtree.api.domain.student.dto.StudentRequestDTO;

import java.util.List;

//이승윤 ver0.1
public interface ProgramService {
    public PageResponseDTO<ProgramListDTO> getProgramLists(ProgramSearchDTO programSearchDTO);

    public List<ProgramListDTO> getProgramListsByStudentId(Long studentId);

    public List<WordCloudDTO> getWordCloudInfo();

    public ProgramDetailsDTO getProgramDetailsById(Long id);

    public long postProgramForm(ProgramFormDTO programFormDTO);

    // 내 프로그램 리스트
    List<ProgramManagerListDTO> myProgramList(Long id);

    // 내 레슨 리스트
    List<ProgramLessonDTO> myLessonList(Long id);

    // 관리자 프로그램 리스트
    PageResponseDTO<AdminProgramListDTO> adminProgramList(StudentRequestDTO studentRequestDTO);

    // 관리자 레슨 리스트
    PageResponseDTO<AdminProgramLessonListDTO> adminProgramLessonList(StudentRequestDTO studentRequestDTO);

    // 프로그램 삭제
    void removeProgram(Long id);

    // 레슨 삭제
    void removeLesson(Long id);

    // 프로그램 수정
    void modifyProgram(ModifyProgramDTO modifyProgramDTO);
}
