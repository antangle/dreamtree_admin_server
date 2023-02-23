package com.dreamtree.api.program;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.domain.program.dto.ProgramFormDTO;
import com.dreamtree.api.domain.program.dto.ProgramSearchDTO;
import com.dreamtree.api.domain.program.mapper.FileMapper;
import com.dreamtree.api.domain.program.mapper.ProgramManagerMapper;
import com.dreamtree.api.domain.program.mapper.ProgramMapper;
import com.dreamtree.api.domain.student.dto.StudentRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class ProgramMapperTests {

    @Autowired(required = false)
    ProgramMapper programMapper;

    @Autowired(required = false)
    FileMapper fileMapper;

    @Autowired(required = false)
    ProgramManagerMapper programManagerMapper;


    @Test
    public void getProgramListsTests(){
        ProgramSearchDTO programSearchDTO = ProgramSearchDTO.builder()
                .keyword("100000")
                .condition("fee")
                .order("times")
                .subCategoryId(1L)
                .build();
        log.info(programMapper.getProgramLists(programSearchDTO));
    }
    @Test
    public void getStudentProgramListsTests(){
        log.info(programMapper.getProgramListsByStudentId(1L));
    }

    @Test
    public void getWordCloudInfoTests(){
        log.info(programMapper.getWordCloudInfo());
    }

    @Test
    public void getProgramListsCountTests(){
        ProgramSearchDTO programSearchDTO = ProgramSearchDTO.builder()
                .keyword("100000")
                .condition("fee")
                .order("times")
                .subCategoryId(1L)
                .build();
        log.info(programMapper.getProgramListsCount(programSearchDTO));
    }

    @Test
    public void getProgramDetailsTests(){
        log.info(programMapper.getProgramDetails(145L));
    }

    @Test
    public void postProgramFormTests(){

        ProgramFormDTO programFormDTO = ProgramFormDTO.builder()
                .title("this is title")
                .content("jfeioawjfoejfio")
                .curriculumJson("{'hi': 'test'}")
                .times(5)
                .fee(10000)
                .fileForms(List.of("url", "url2", "url3"))
                .build();



//        programMapper.postProgramForm(programFormDTO);

        log.info(fileMapper.postFileForm(programFormDTO));
    }

    @Test
    public void getAdminProgramList() {

        StudentRequestDTO studentRequestDTO = new StudentRequestDTO();
        StudentRequestDTO.builder()
                .build();

        studentRequestDTO.setPage(1);
        studentRequestDTO.setSize(1);
        studentRequestDTO.setKeyword("");
        studentRequestDTO.setCondition("title,nickname");

        log.info(programManagerMapper.getAdminProgramList(studentRequestDTO));
    }

}
