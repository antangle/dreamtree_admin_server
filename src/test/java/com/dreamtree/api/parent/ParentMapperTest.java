package com.dreamtree.api.parent;

import com.dreamtree.api.domain.parent.dto.ParentInfoReqDTO;
import com.dreamtree.api.domain.parent.dto.ParentInfoResDTO;
import com.dreamtree.api.domain.parent.dto.ParentModDTO;
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

    @Test
    public void testUpdateParentInfo() {

        log.info("============Update Parent Info==========");

        ParentModDTO modDTO = ParentModDTO.builder()
                .id(38L)
                .nickname("Kaya")
                .password("Tikehau Airport")
                .profile_img_url("http://dummyimage.com/102x100.png/ff4444/ffffff")
                .build();

        parentMapper.updateParentInfo(modDTO);

    }

    @Test
    public void testSoftDeleteParent() {

        log.info("============Soft Delete Parent Info==========");

        Long id = 1L;

        parentMapper.softDeleteOneParent(id);
    }
}
