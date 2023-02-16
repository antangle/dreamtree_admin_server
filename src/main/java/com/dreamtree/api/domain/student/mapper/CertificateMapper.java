package com.dreamtree.api.domain.student.mapper;

import com.dreamtree.api.domain.student.dto.*;

import java.util.List;

/*** 임성현 ver.0.1 ***/

public interface CertificateMapper {

    // 자격증 추가
    int addCertificate(CertificateAddDTO certificateAddDTO);

    // 자격증 조회
    CertificateDetailDTO getCertificate(Long id);

    // 자격증 리스트
    List<CertificateListDTO> getCertificateList(Long id);

    // 자격증 인증 상태 업데이트
    int modifyCertificateAuthState(CertificateModifyDTO certificateModifyDTO);

    // 자격증 삭제
    int removeCertificate(Long id);

}
