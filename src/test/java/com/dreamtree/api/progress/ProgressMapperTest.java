package com.dreamtree.api.progress;

import com.dreamtree.api.domain.progress.dto.ProgressResDTO;
import com.dreamtree.api.domain.progress.mapper.ProgressMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//최서연 ver.0.2
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

    @Test
    public void testGetProgressListCount() {

        log.info("===============TEST GET PROGRESS LIST COUNT=============");

        Long parent_id = 13L;

        int count = progressMapper.getProgressListCount(parent_id);

        log.info(count);

    }

    @Test
    public void testSetState() {

        log.info("===============TEST SET PROGRESS STATE=============");




    }

}
