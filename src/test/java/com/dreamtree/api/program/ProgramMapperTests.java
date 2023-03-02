package com.dreamtree.api.program;

import com.dreamtree.api.common.dto.PageRequestDTO;
import com.dreamtree.api.domain.program.dto.FileTypeDTO;
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
import java.util.stream.IntStream;

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

        IntStream.range(1, 150).forEach((i) -> {
            ProgramFormDTO programFormDTO = ProgramFormDTO.builder()
                    .studentId(i % 5)
                    .subCategoryId(1 + i%28)
                    .title("좋은 강의입니다")
                    .content("2년차 경력의 과외 선생님입니다.")
                    .curriculumJson("[[], [], []]")
                    .times(3)
                    .fee(110000)
                    .fileForms(List.of(FileTypeDTO.builder()
                                    .contentType("")
                                    .filename("")
                            .build()))
                    .build();
            programMapper.postProgramForm(programFormDTO);
        });


//        log.info(fileMapper.postFileForm(programFormDTO));
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

    @Test
    public void getMyLessonList() {

        log.info(programManagerMapper.getMyLessonList(1L));
    }
}
