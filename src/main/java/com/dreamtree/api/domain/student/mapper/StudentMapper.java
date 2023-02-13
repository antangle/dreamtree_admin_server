package com.dreamtree.api.domain.student.mapper;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.domain.student.dto.StudentAddDTO;
import com.dreamtree.api.domain.student.dto.StudentAddFileDTO;
import com.dreamtree.api.domain.student.dto.StudentDTO;
import com.dreamtree.api.domain.student.dto.StudentModifyDTO;

import java.util.List;

public interface StudentMapper {

    // 학생 1 추가
    void addStudent(StudentAddDTO studentAddDTO);

    // 학생 파일 정보 추가
    void addStudentFile(StudentAddFileDTO studentAddFileDTO);

    // 학생 1명 조회
    StudentDTO getStudent(Long id);

    // 학생 10명 검색
    List<StudentDTO> getStudentList(PageRequestDTO pageRequestDTO);

    // 학생 검색 (nickname, email, auth_state)


    // 학생 1명 삭제 (UPDATE deletedAt)
    void removeStudent(Long id);

    // 학생 정보 수정
    void modifyStudent(StudentModifyDTO studentModifyDTO);

    // 학생 인증 상태 업데이트
    void modifyStudentAuthState(Long id, String state);

}
