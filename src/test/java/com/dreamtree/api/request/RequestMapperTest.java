package com.dreamtree.api.request;

import com.dreamtree.api.domain.request.dto.RequestAddDTO;
import com.dreamtree.api.domain.request.dto.RequestReqDTO;
import com.dreamtree.api.domain.request.dto.RequestResDTO;
import com.dreamtree.api.domain.request.mapper.RequestMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class RequestMapperTest {

    @Autowired(required = false)
    RequestMapper requestMapper;

    @Test
    public void testAddRequest() {

        log.info("=================TEST ADD REQUEST===============");

        RequestAddDTO addDTO = RequestAddDTO.builder()
                .title("Test Title")
                .parent_id(2L)
                .sub_category_id(5)
                .description("Lorem ipsum...")
                .content("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                .student_grade("저학년")
                .student_gender("female")
                .build();

        requestMapper.addRequest(addDTO);
        log.info(addDTO);

    }

    @Test
    public void testGetAllRequestsList() {

        log.info("=================TEST GET ALL REQUESTS===============");

        RequestReqDTO reqDTO = new RequestReqDTO();

        List<RequestResDTO> res = requestMapper.getAllRequests(reqDTO);
        log.info(res.size());

    }

    @Test
    public void testGetAllRequestsCount() {

        log.info("=================TEST GET REQUESTS COUNT===============");

        log.info(requestMapper.getAllRequestsCount());
    }

    @Test
    public void testGetOneRequest() {

        log.info("=================TEST GET REQUEST===============");

        Long id = 103L;

        log.info(requestMapper.getOneRequest(id));
    }

}
