package com.dreamtree.api.domain.program.mapper;

import com.dreamtree.api.domain.program.dto.ProgramLessonDTO;
import com.dreamtree.api.domain.program.dto.ProgramManagerListDTO;

import java.util.List;

public interface ProgramManagerMapper {

    // 내 프로그램 and 상세 리스트
    List<ProgramManagerListDTO> getMyProgramList(Long id);

    // 프로그램 and 레슨 리스트
    List<ProgramLessonDTO> getMyLessonList(Long id);
}
