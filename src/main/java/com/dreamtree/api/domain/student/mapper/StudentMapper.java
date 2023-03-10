package com.dreamtree.api.domain.student.mapper;

import com.dreamtree.api.common.auth.kakaologin.dto.KakaoResDTO;
import com.dreamtree.api.common.auth.kakaologin.dto.KakaoTokenResDTO;
import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.domain.student.dto.*;

import java.util.List;

/*** 임성현 ver.0.2 ***/

public interface StudentMapper {

    // 학생 1 추가
    int addStudent(StudentAddDTO studentAddDTO);

    // 학생 학교 정보 추가
    int addStudentFile(StudentAddFileDTO studentAddFileDTO);

    // 학생 학교 정보 조회
    StudentCollegeDTO getStudentCollege(Long id);

    // 학생 1명 조회
    StudentDetailDTO getStudent(Long id);

    StudentDetailDTO getStudentWithEmail(String email);

    // 학생 10명 검색
    List<StudentDTO> getStudentList(PageRequestDTO pageRequestDTO);

    // 학생 검색 (nickname, email, auth_state)
    List<StudentListDTO> getSearchStudentList(StudentRequestDTO studentRequestDTO);

    // 학생 1명 삭제 (UPDATE deletedAt)
    int removeStudent(Long id);

    // 학생 정보 수정
    int modifyStudent(StudentModifyDTO studentModifyDTO);

    // 학생 인증 상태 업데이트
    int modifyStudentAuthState(Long id, String authState);

    // 대학인증 요청 리스트
    List<StudentAuthRequestDTO> getSearchCollegeAuthRequestList(StudentRequestDTO studentRequestDTO);

    // 자격/수상 인증 요청 리스트
    List<StudentAuthRequestDTO> getSearchCertificateAuthRequestList(StudentRequestDTO studentRequestDTO);

    int getStudentListCount(StudentRequestDTO studentRequestDTO);

    int getCollegeListCount(StudentRequestDTO studentRequestDTO);

    int getCertificateListCount(StudentRequestDTO studentRequestDTO);

    int getCollegeAuthCount();

    /** kakao login **/ /*** 최서연 ver.0.1 ***/
    // 학생 회원 카카오 토큰 정보 조회
    KakaoTokenResDTO getStudentKakaoTokenInfo(String email);

    // 학생 회원 카카오 토큰 정보 업데이트
    int updateStudentKakaoTokenInfo(KakaoTokenResDTO resDTO);

    // 이메일로 회원 ID & 권한 정보 조회
    KakaoResDTO getStudentInfoWithEmail(String email);

    // 카카오 로그인 정보로 회원가입
    int addStudentWithKakao(StudentKakaoAddDTO addDTO);

    // 이메일로 회원 조회
    EmailStudentDTO getEmailStudent(String email);
}
