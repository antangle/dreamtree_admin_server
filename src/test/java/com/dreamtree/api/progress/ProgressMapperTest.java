package com.dreamtree.api.progress;

import com.dreamtree.api.domain.parent.dto.ProgressResDTO;
import com.dreamtree.api.domain.parent.mapper.ProgressMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class ProgressMapperTest {

    @Autowired(required = false)
    ProgressMapper progressMapper;

    @Test
    public void testGetProgressList() {

        log.info("===============TEST GET PROGRESS LIST=============");

        Long parent_id = 5L;

        List<ProgressResDTO> res = progressMapper.getProgressList(parent_id);

        log.info(res);

    }

}
