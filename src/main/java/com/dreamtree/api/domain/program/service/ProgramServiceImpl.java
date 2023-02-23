package com.dreamtree.api.domain.program.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.common.enums.ErrorEnum;
import com.dreamtree.api.domain.program.dto.*;
import com.dreamtree.api.domain.program.mapper.FileMapper;
import com.dreamtree.api.domain.program.mapper.ProgramManagerMapper;
import com.dreamtree.api.domain.program.mapper.ProgramMapper;
import com.dreamtree.api.domain.student.dto.StudentRequestDTO;
import com.dreamtree.api.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//이승윤 ver0.2
@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ProgramServiceImpl implements ProgramService{
    private final ProgramMapper programMapper;
    private final FileMapper fileMapper;

    private final ProgramManagerMapper programManagerMapper;

    @Override
    public List<WordCloudDTO> getWordCloudInfo() {
        List<WordCloudDTO> list = programMapper.getWordCloudInfo();

        if(list.size() == 0) throw new CustomException(ErrorEnum.NO_PROGRAM);

        return list;
    }

    @Override
    public PageResponseDTO<ProgramListDTO> getProgramLists(ProgramSearchDTO programSearchDTO) {

        List<ProgramListDTO> list = programMapper.getProgramLists(programSearchDTO);

        int count = programMapper.getProgramListsCount(programSearchDTO);

        //페이징 DTO 생성
        PageResponseDTO<ProgramListDTO> pagedProgramListDTO = PageResponseDTO.<ProgramListDTO>withAll()
                .pageRequestDTO(programSearchDTO)
                .dtoList(list)
                .total(count)
                .build();

        return pagedProgramListDTO;
    }

    @Override
    public List<ProgramListDTO> getProgramListsByStudentId(Long studentId) {

        List<ProgramListDTO> list = programMapper.getProgramListsByStudentId(studentId);

        if(list.size() == 0) throw new CustomException(ErrorEnum.STUDENT_NO_PROGRAM);

        return list;
    }

    @Override
    public ProgramDetailsDTO getProgramDetailsById(Long id) {

        ProgramDetailsDTO programDetailsDTO = programMapper.getProgramDetails(id);

        if(programDetailsDTO.getTitle() == null) throw new CustomException(ErrorEnum.NO_PROGRAM_DETAIL);

        return programDetailsDTO;
    }

    @Override
    public long postProgramForm(ProgramFormDTO programFormDTO) {

        //프로그램 insert
        int postProgramCount = programMapper.postProgramForm(programFormDTO);

        //insert된 프로그램 개수에 문제가 있을시
        if(programFormDTO.getProgramId() == 0 || postProgramCount != 1) throw new CustomException(ErrorEnum.POST_PROGRAM_FORM_FAIL);

        //첨부한 파일이 있을시
        if(programFormDTO.getFileForms().size() > 0){
            int postFileCount = fileMapper.postFileForm(programFormDTO);

            //첨부한 파일 개수가 안맞을때
            if(postFileCount != programFormDTO.getFileForms().size()) throw new CustomException(ErrorEnum.NO_CATEGORY);
        }

        return programFormDTO.getProgramId();
    }

    @Override
    public List<ProgramManagerListDTO> myProgramList(Long id) {

        return programManagerMapper.getMyProgramList(id);
    }

    @Override
    public List<ProgramLessonDTO> myLessonList(Long id) {

        return programManagerMapper.getMyLessonList(id);
    }

    @Override
    public PageResponseDTO<AdminProgramListDTO> adminProgramList(StudentRequestDTO studentRequestDTO) {

        List<AdminProgramListDTO> list = programManagerMapper.getAdminProgramList(studentRequestDTO);

        log.info("list: " + list);

        int count = programManagerMapper.getAdminProgramCount(studentRequestDTO);

        PageResponseDTO<AdminProgramListDTO> pageResponseDTO = PageResponseDTO.<AdminProgramListDTO>withAll()
                .pageRequestDTO(studentRequestDTO)
                .dtoList(list)
                .total(count)
                .build();

        return pageResponseDTO;
    }

    @Override
    public PageResponseDTO<AdminProgramLessonListDTO> adminProgramLessonList(StudentRequestDTO studentRequestDTO) {

        List<AdminProgramLessonListDTO> list = programManagerMapper.getAdminLessonList(studentRequestDTO);

        log.info("list: " + list);

        int count = programManagerMapper.getAdminLessonCount(studentRequestDTO);

        PageResponseDTO<AdminProgramLessonListDTO> pageResponseDTO = PageResponseDTO.<AdminProgramLessonListDTO>withAll()
                .pageRequestDTO(studentRequestDTO)
                .dtoList(list)
                .total(count)
                .build();

        return pageResponseDTO;
    }

    @Override
    public void removeProgram(Long id) {

        programManagerMapper.removeProgram(id);
    }

    @Override
    public void removeLesson(Long id) {

        programManagerMapper.removeLesson(id);
    }

    @Override
    public void modifyProgram(ModifyProgramDTO modifyProgramDTO) {

        programManagerMapper.modifyProgram(modifyProgramDTO);
    }

}
