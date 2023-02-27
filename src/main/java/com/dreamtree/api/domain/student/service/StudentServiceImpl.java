package com.dreamtree.api.domain.student.service;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.common.enums.StudentErrorEnum;
import com.dreamtree.api.domain.student.dto.*;
import com.dreamtree.api.domain.student.mapper.StudentMapper;
import com.dreamtree.api.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*** 임성현 ver.0.1 ***/

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class StudentServiceImpl implements StudentService  {

    private final StudentMapper studentMapper;

    @Override
    public void addStudent(StudentAddDTO studentAddDTO) {

        log.info("Add Student");
        log.info("StudentAddDTO: " + studentAddDTO);

        if(studentMapper.addStudent(studentAddDTO) < 1) throw new CustomException(StudentErrorEnum.POST_STUDENT_FORM_FAIL);
    }

    @Override
    public void addStudentFile(StudentAddFileDTO studentAddFileDTO) {

        log.info("Add StudentFile");
        log.info("StudentFile: " + studentAddFileDTO);

        if(studentMapper.addStudentFile(studentAddFileDTO) < 1) throw new CustomException(StudentErrorEnum.POST_STUDENT_FILE_FORM_FAIL);
    }

    @Override
    public StudentCollegeDTO getStudentCollege(Long id) {

        log.info("Get Student College");
        log.info("Id: " + id);

        StudentCollegeDTO studentCollegeDTO = studentMapper.getStudentCollege(id);


        if(studentCollegeDTO.getCollege() == null) throw new CustomException(StudentErrorEnum.NO_COLLEGE);

        return studentCollegeDTO;
    }

    @Override
    public StudentDetailDTO getStudent(Long id) {

        log.info("Get Student");
        log.info("Id: " + id);

        StudentDetailDTO studentDetailDTO = studentMapper.getStudent(id);

        if(studentDetailDTO.getNickname() == null) throw new CustomException(StudentErrorEnum.NO_STUDENT_DETAIL);


        return studentDetailDTO;
    }

    @Override
    public List<StudentDTO> getStudentList(PageRequestDTO pageRequestDTO) {

        log.info("Get StudentList");
        log.info("StudentRequestDTO: " + pageRequestDTO);

        return studentMapper.getStudentList(pageRequestDTO);
    }

    @Override
    public PageResponseDTO<StudentListDTO> getSearchStudentList(StudentRequestDTO studentRequestDTO) {

        log.info("Get Search Student List");

        List<StudentListDTO> list = studentMapper.getSearchStudentList(studentRequestDTO);

        log.info("List: " + list);

        int count = studentMapper.getStudentListCount(studentRequestDTO);

        PageResponseDTO<StudentListDTO> pageResponseDTO = PageResponseDTO.<StudentListDTO>withAll()
                .pageRequestDTO(studentRequestDTO)
                .dtoList(list)
                .total(count)
                .build();


        return pageResponseDTO;
    }

    @Override
    public void removeStudent(Long id) {

        log.info("Remove Student");
        log.info("Id: " + id);

        if(studentMapper.removeStudent(id) < 1) throw new CustomException(StudentErrorEnum.DELETE_STUDENT_FAIL);
    }

    @Override
    public void modifyStudent(StudentModifyDTO studentModifyDTO) {

        log.info("Modify Student");
        log.info("StudentModifyDTO: " + studentModifyDTO);

        if(studentMapper.modifyStudent(studentModifyDTO) < 1) throw new CustomException(StudentErrorEnum.MODIFY_STUDENT_FAIL);
    }

    @Override
    public void modifyStudentAuthState(Long id, String authState) {

        log.info("Modify Auth State");
        log.info("Id: " + id);
        log.info("Auth State: " + authState);

        if(studentMapper.modifyStudentAuthState(id, authState) < 1) throw new CustomException(StudentErrorEnum.MODIFY_STUDENT_AUTH_FAIL);
    }

    @Override
    public PageResponseDTO<StudentAuthRequestDTO> getSearchCollegeAuthRequestList(StudentRequestDTO studentRequestDTO) {

        log.info("Get Search College Auth Request List");

        log.info(studentRequestDTO);

        List<StudentAuthRequestDTO> list = studentMapper.getSearchCollegeAuthRequestList(studentRequestDTO);

        int count = studentMapper.getCollegeListCount(studentRequestDTO);

        log.info("List: " + list);

        PageResponseDTO<StudentAuthRequestDTO> pageResponseDTO = PageResponseDTO.<StudentAuthRequestDTO>withAll()
                .pageRequestDTO(studentRequestDTO)
                .dtoList(list)
                .total(count)
                .build();

        return pageResponseDTO;
    }

    @Override
    public PageResponseDTO<StudentAuthRequestDTO> getSearchCertificateAuthRequestList(StudentRequestDTO studentRequestDTO) {

        log.info("Get Search Certificate Auth Request");

        List<StudentAuthRequestDTO> list = studentMapper.getSearchCertificateAuthRequestList(studentRequestDTO);

        log.info("List: " + list);

        int count = studentMapper.getCertificateListCount(studentRequestDTO);

        PageResponseDTO<StudentAuthRequestDTO> pageResponseDTO = PageResponseDTO.<StudentAuthRequestDTO>withAll()
                .pageRequestDTO(studentRequestDTO)
                .dtoList(list)
                .total(count)
                .build();

        return pageResponseDTO;
    }

    @Override
    public int getCollegeAuthCount() {

        return studentMapper.getCollegeAuthCount();
    }

    @Override
    public EmailStudentDTO getEmailStudent(String email) {

        return studentMapper.getEmailStudent(email);
    }
}
