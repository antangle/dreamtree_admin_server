package com.dreamtree.api.pay;

import com.dreamtree.api.common.enums.RoleEnum;
import com.dreamtree.api.common.kakaopay.dto.AfterKakaoPayReadyDTO;
import com.dreamtree.api.common.kakaopay.mapper.PayMapper;
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
public class PayMapperTests {

    @Autowired(required = false)
    PayMapper payMapper;

    @Test
    public void test(){
        log.info("123" + 4L);
    }

    @Test
    public void testGetParentList() {
        AfterKakaoPayReadyDTO afterKakaoPayReadyDTO = AfterKakaoPayReadyDTO.builder()
                .itemName("test")
                .memberId(1L)
                .totalAmount(13)
                .memberRole(RoleEnum.PARENT.toString())
                .build();
        payMapper.insertPay(afterKakaoPayReadyDTO);

    }
}
