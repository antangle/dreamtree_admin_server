package com.dreamtree.api.domain.program.mapper;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.domain.program.dto.*;
import com.dreamtree.api.domain.student.dto.StudentRequestDTO;

import java.util.List;

public interface ProgramManagerMapper {

    // 내 프로그램 and 상세 리스트
    List<ProgramManagerListDTO> getMyProgramList(Long id);

    // 프로그램 and 레슨 리스트
    List<ProgramLessonDTO> getMyLessonList(Long id);

    // 관리자 프러그램 and 상세 리스트
    List<AdminProgramListDTO> getAdminProgramList(StudentRequestDTO studentRequestDTO);

    // 관리자 프로그램 리스트 카운트
    int getAdminProgramCount(StudentRequestDTO studentRequestDTO);

    // 관리자 프로그램 and 레슨 리스트
    List<AdminProgramLessonListDTO> getAdminLessonList(StudentRequestDTO studentRequestDTO);

    // 관리자 프로그램 리스트 카운트
    int getAdminLessonCount(StudentRequestDTO studentRequestDTO);

    // 프로그램 수정
    int modifyProgram(ModifyProgramDTO modifyProgramDTO);

    // 프로그램 삭제
    int removeProgram(Long id);

    // 레슨 삭제
    int removeLesson(Long id);
}
