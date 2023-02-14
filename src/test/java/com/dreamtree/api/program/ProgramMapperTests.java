package com.dreamtree.api.program;

import com.dreamtree.api.domain.category.mapper.CategoryMapper;
import com.dreamtree.api.domain.program.dto.FileFormDTO;
import com.dreamtree.api.domain.program.dto.ProgramFormDTO;
import com.dreamtree.api.domain.program.dto.ProgramSearchDTO;
import com.dreamtree.api.domain.program.mapper.FileMapper;
import com.dreamtree.api.domain.program.mapper.ProgramMapper;
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
        log.info(programMapper.getProgramDetails(1L));
    }

    @Test
    public void postProgramFormTests(){
        FileFormDTO fileFormDTO = FileFormDTO.builder()
                .url("url")
                .contentType("png")
                .name("filename")
                .size(100)
                .build();

        ProgramFormDTO programFormDTO = ProgramFormDTO.builder()
                .title("this is title")
                .content("jfeioawjfoejfio")
                .curriculumJson("{'hi': 'test'}")
                .times(5)
                .fee(10000)
                .fileForms(List.of(fileFormDTO))
                .build();



        programMapper.postProgramForm(programFormDTO);

        log.info(fileMapper.postFileForm(programFormDTO));
    }

}
