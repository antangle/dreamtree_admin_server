package com.dreamtree.api.student.mapper;


import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.domain.student.dto.*;
import com.dreamtree.api.domain.student.mapper.StudentMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Log4j2
public class StudentMapperTests {

    @Autowired(required = false)
    StudentMapper studentMapper;

    // 학생 추가
    @Test
    public void studentAddTest() {

        log.info("stu Add....");

        StudentAddDTO studentAddDTO = StudentAddDTO.builder()
                .email("t email")
                .birth(LocalDate.now())
                .password("t pwd")
                .nickname("t nick")
                .gender("man")
                .profile_img_url("t img")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        studentMapper.addStudent(studentAddDTO);
    }

    // 학생 파일 추가
    @Test
    public void studentAddFileTest() {

        log.info("student add file...");

        StudentAddFileDTO studentAddFileDTO = StudentAddFileDTO.builder()
                .student_id(105L)
                .auth_url("t auth_url")
                .college("t collage")
                .url("t url")
                .major("t major")
                .build();

        studentMapper.addStudentFile(studentAddFileDTO);
    }

    // 학생 1명 조회
    @Test
    public void studentGetTest() {

        log.info("stu get one....");

        log.info(studentMapper.getStudent(105l));
    }

    // 학생 10명 검색
    @Test
    public void studentGetListTest() {

        log.info("stu get list.....");

        log.info(studentMapper.getStudentList(new PageRequestDTO()));
    }

    // 학생 키워드(전체, 이메일, 닉네임, 인증상태) 검색
    @Test
    public void searchStudentGetListTest() {

        log.info("search stu list....");


        StudentRequestDTO studentRequestDTO = new StudentRequestDTO();

        // 전체 ok
        studentRequestDTO.setCondition("total");
        studentRequestDTO.setKeyword("nick");

        // 닉네임 ok
//        studentRequestDTO.setCondition("nickname");
//        studentRequestDTO.setKeyword("nick");

        // 인증 상태 ok
//        studentRequestDTO.setCondition("auth_state");
//        studentRequestDTO.setKeyword("stu");

        // 이메일 ok
//        studentRequestDTO.setCondition("email");
//        studentRequestDTO.setKeyword("test");

        List<StudentDTO> stuList = studentMapper.getSearchStudentList(studentRequestDTO);

        log.info("search result: " + stuList);
        log.info("search size: " + stuList.size());
    }


    // 학생 1명 삭제 (UPDATE deletedAt)
    @Test
    public void removeStudentTest() {

        log.info("remove student.....");

        studentMapper.removeStudent(105L);
    }

    // 학생 정보 수정
    @Test
    public void modifyStudentTest() {

        log.info("modify student....");

        StudentModifyDTO studentModifyDTO = StudentModifyDTO.builder()
                .student_id(105L)
                .gender("tman")
                .birth(LocalDate.now())
                .nickname("test nick...")
                .password("test pwd...")
                .profile_img_url("test profile img,,,")
                .build();

        studentMapper.modifyStudent(studentModifyDTO);
    }

    // 학생 인증 상태 업데이트
    @Test
    public void modifyStudentAuthState() {

        log.info("modify auth state....");

        studentMapper.modifyStudentAuthState(105L, "student");
    }

}