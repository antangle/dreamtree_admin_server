package com.dreamtree.api.student.mapper;


import com.dreamtree.api.domain.student.dto.CertificateAddDTO;
import com.dreamtree.api.domain.student.dto.CertificateDTO;
import com.dreamtree.api.domain.student.dto.CertificateListDTO;
import com.dreamtree.api.domain.student.dto.CertificateModifyDTO;
import com.dreamtree.api.domain.student.mapper.CertificateMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Log4j2
public class CertificateMapperTests {

    @Autowired(required = false)
    CertificateMapper certificateMapper;

    // 자격증 추가
    @Test
    public void addCertificateTest() {

        log.info("add certificate ...");

        CertificateAddDTO certificateDTO = CertificateAddDTO.builder()
                .studentId(105L)
                .name("test cer14")
                .url("test url14")
                .aquireDate(LocalDate.now())
                .build();

        certificateMapper.addCertificate(certificateDTO);
    }

    // 자격증 조회
    @Test
    public void getCertificate() {

        log.info("get certificate....");

        log.info(certificateMapper.getCertificate(101L));
    }

    // 자격증 인증상태 업데이트
//    @Test
//    public void modifyCertificateAuthState() {
//
//        log.info("modify cer auth...");
//
//        CertificateModifyDTO certificateModifyDTO = CertificateModifyDTO.builder()
//                .certificateId(101L)
//                .authState("TT")
//                .studentId(105L)
//                .build();
//
//        certificateMapper.modifyCertificateAuthState(certificateModifyDTO);
//    }

    // 자격증 전체 검색
    @Test
    public void getCertificateListTest() {

        log.info("get cet list ....");

        List<CertificateListDTO> cer = certificateMapper.getCertificateList(104L);

        log.info(cer);
    }
}
