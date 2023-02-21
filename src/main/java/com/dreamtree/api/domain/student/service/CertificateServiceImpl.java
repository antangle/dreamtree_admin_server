package com.dreamtree.api.domain.student.service;

import com.dreamtree.api.common.enums.StudentErrorEnum;
import com.dreamtree.api.domain.student.dto.CertificateAddDTO;
import com.dreamtree.api.domain.student.dto.CertificateDetailDTO;
import com.dreamtree.api.domain.student.dto.CertificateListDTO;
import com.dreamtree.api.domain.student.dto.CertificateModifyDTO;
import com.dreamtree.api.domain.student.mapper.CertificateMapper;
import com.dreamtree.api.exception.CustomException;
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

        if(certificateMapper.addCertificate(certificateAddDTO) < 1) throw new CustomException(StudentErrorEnum.POST_CERTIFICATE_FORM_FAIL);
    }

    @Override
    public CertificateDetailDTO getCertificate(Long id) {

        log.info("Get Certificate");
        log.info("id: " + id);

        CertificateDetailDTO certificateDetailDTO = certificateMapper.getCertificate(id);

        if(certificateDetailDTO.getName() == null) throw new CustomException(StudentErrorEnum.NO_CERTIFICATE_DETAIL);

        return certificateDetailDTO;

    }

    @Override
    public List<CertificateListDTO> getCertificateList(Long id) {

        log.info("Get Certificate List");
        log.info("Student Id: " + id);

        List<CertificateListDTO> list = certificateMapper.getCertificateList(id);

        return list;
    }

    @Override
    public void modifyCertificateAuthState(CertificateModifyDTO certificateModifyDTO) {

        log.info("Modify CertificateAuth State");
        log.info("certificateModifyDTO: " + certificateModifyDTO);

        if(certificateMapper.modifyCertificateAuthState(certificateModifyDTO) < 1) throw new CustomException(StudentErrorEnum.MODIFY_CERTIFICATE_FAIL);
    }

    @Override
    public void removeCertificate(Long id) {

        log.info("Remove Certificate");
        log.info("Id: " + id);

        if(certificateMapper.removeCertificate(id) < 1) throw new CustomException(StudentErrorEnum.DELETE_CERTIFICATE_FAIL);
    }

    @Override
    public int getCertificateAuthCount() {

        return certificateMapper.getCertificateAuthCount();
    }
}
