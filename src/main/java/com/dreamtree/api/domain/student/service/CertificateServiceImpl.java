package com.dreamtree.api.domain.student.service;

import com.dreamtree.api.domain.student.dto.CertificateAddDTO;
import com.dreamtree.api.domain.student.dto.CertificateDetailDTO;
import com.dreamtree.api.domain.student.dto.CertificateListDTO;
import com.dreamtree.api.domain.student.dto.CertificateModifyDTO;
import com.dreamtree.api.domain.student.mapper.CertificateMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*** 임성현 ver.0.1 ***/

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class CertificateServiceImpl implements CertificateService {

    private final CertificateMapper certificateMapper;

    @Override
    public void addCertificate(CertificateAddDTO certificateAddDTO) {

        log.info("Add Certificate");
        log.info("CertificateDTO: " + certificateAddDTO);

        certificateMapper.addCertificate(certificateAddDTO);
    }

    @Override
    public CertificateDetailDTO getCertificate(Long certificateId, Long studentId) {

        log.info("Get Certificate");
        log.info("Certificate Id: " + certificateId);
        log.info("Student Id");

        return null;
    }

    @Override
    public List<CertificateListDTO> getCertificateList(Long id) {
        return null;
    }

    @Override
    public void modifyCertificateAuthState(CertificateModifyDTO certificateModifyDTO) {

    }

    @Override
    public void removeCertificate(Long id) {

    }
}
