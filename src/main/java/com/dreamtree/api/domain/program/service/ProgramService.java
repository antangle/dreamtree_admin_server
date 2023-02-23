package com.dreamtree.api.domain.program.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.program.dto.*;

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

}
