package com.dreamtree.api.domain.student.service;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.student.dto.*;

import java.util.List;

/*** 임성현 ver.0.1 ***/

public interface StudentService {

    // 학생 추가
    void addStudent(StudentAddDTO studentAddDTO);

    // 학생 학교 정보 추가
    void addStudentFile(StudentAddFileDTO studentAddFileDTO);

    // 학생 학교 정보 조회
    StudentCollegeDTO getStudentCollege(Long id);

    // 학생 조회
    StudentDetailDTO getStudent(Long id);

    // 학생 10명 검색
    List<StudentDTO> getStudentList(PageRequestDTO pageRequestDTO);

    // 학생 검색 (nickname, email, auth_state)
    PageResponseDTO<StudentListDTO> getSearchStudentList(StudentRequestDTO studentRequestDTO);

    // 학생 1명 삭제 (UPDATE deletedAt)
    void removeStudent(Long id);

    // 학생 정보 수정
    void modifyStudent(StudentModifyDTO studentModifyDTO);

    // 학생 인증 상태 업데이트
    void modifyStudentAuthState(Long id, String authState);

    // 대학인증 요청 리스트
    PageResponseDTO<StudentAuthRequestDTO> getSearchCollegeAuthRequestList(StudentRequestDTO studentRequestDTO);

    // 자격/수상 인증 요청 리스트
    PageResponseDTO<StudentAuthRequestDTO> getSearchCertificateAuthRequestList(StudentRequestDTO studentRequestDTO);

}
