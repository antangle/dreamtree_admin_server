package com.dreamtree.api.program;

import com.dreamtree.api.domain.category.mapper.CategoryMapper;
import com.dreamtree.api.domain.program.dto.ProgramSearchDTO;
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


    @Test
    public void getProgramListsTests(){
        ProgramSearchDTO programSearchDTO = ProgramSearchDTO.builder()
                .keyword("100000")
                .condition(List.of("fee"))
                .order("")
                .subCategoryId(1L)
                .build();
        log.info(programMapper.getProgramLists(programSearchDTO));
    }

    @Test
    public void getProgramDetailsTests(){
        log.info(programMapper.getProgramDetails(1L));
    }
}
