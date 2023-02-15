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

        studentMapper.addStudent(studentAddDTO);
    }

    @Override
    public void addStudentFile(StudentAddFileDTO studentAddFileDTO) {

        log.info("Add StudentFile");
        log.info("StudentFile: " + studentAddFileDTO);

        studentMapper.addStudentFile(studentAddFileDTO);
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

        //if(studentDetailDTO.getNickname() == null) throw new CustomException(StudentErrorEnum.NO_STUDENT);


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

        studentMapper.removeStudent(id);
    }

    @Override
    public void modifyStudent(StudentModifyDTO studentModifyDTO) {

        log.info("Modify Student");
        log.info("StudentModifyDTO: " + studentModifyDTO);

        studentMapper.modifyStudent(studentModifyDTO);
    }

    @Override
    public PageResponseDTO<StudentAuthRequestDTO> getSearchCollegeAuthRequestList(StudentRequestDTO studentRequestDTO) {

        log.info("Get Search College Auth Request List");

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
}
