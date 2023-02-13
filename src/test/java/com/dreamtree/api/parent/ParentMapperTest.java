package com.dreamtree.api.parent;

import com.dreamtree.api.domain.parent.dto.ParentInfoReqDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoResDTO;
import com.dreamtree.api.domain.parent.mapper.ParentMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class ParentMapperTest {

    @Autowired(required = false)
    ParentMapper parentMapper;

    @Test
    public void testGetParentList() {

        log.info("============Get All Parent List==========");

        ParentInfoReqDTO req = new ParentInfoReqDTO();

        List<ParentInfoResDTO> res = parentMapper.getParentList(req);

        log.info(res);
    }

    @Test
    public void testGetCount() {

        log.info("============Get Parent Count==========");

        ParentInfoReqDTO req = new ParentInfoReqDTO();

        int count = parentMapper.getCount(req);

        log.info(count);
    }

    @Test
    public void testGetOneParentInfo() {

        log.info("============Get Parent Count==========");

        Long id = 38L;

        ParentInfoResDTO res = parentMapper.getOneParentInfo(id);

        log.info(res);
    }

}
