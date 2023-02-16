package com.dreamtree.api.domain.student.service;

import com.dreamtree.api.domain.student.dto.CertificateAddDTO;
import com.dreamtree.api.domain.student.dto.CertificateDetailDTO;
import com.dreamtree.api.domain.student.dto.CertificateListDTO;
import com.dreamtree.api.domain.student.dto.CertificateModifyDTO;

import java.util.List;

/*** 임성현 ver.0.1 ***/

public interface CertificateService {

    // 자격증 추가
    void addCertificate(CertificateAddDTO certificateAddDTO);

    // 자격증 조회
    CertificateDetailDTO getCertificate(Long certificateId, Long studentId);

    // 자격증 리스트
    List<CertificateListDTO> getCertificateList(Long id);

    // 자격증 인증 상태 업데이트
    void modifyCertificateAuthState(CertificateModifyDTO certificateModifyDTO);

    // 자격증 삭제
    void removeCertificate(Long id);

}
