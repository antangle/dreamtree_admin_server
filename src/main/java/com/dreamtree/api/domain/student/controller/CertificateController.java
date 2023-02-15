package com.dreamtree.api.domain.student.controller;

import com.dreamtree.api.domain.student.dto.CertificateAddDTO;
import com.dreamtree.api.domain.student.dto.CertificateDetailDTO;
import com.dreamtree.api.domain.student.dto.CertificateListDTO;
import com.dreamtree.api.domain.student.dto.CertificateModifyDTO;
import com.dreamtree.api.domain.student.service.CertificateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*** 임성현 ver.0.1 ***/

@RestController
@Log4j2
@RequestMapping("api/certificate")
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService certificateService;

    @GetMapping("/{id}")
    public List<CertificateListDTO> getCertificateList(@PathVariable("id") Long id) {

        return certificateService.getCertificateList(id);
    }

    @PostMapping("/form")
    public void addCertificate(@RequestBody CertificateAddDTO certificateAddDTO) {

        certificateService.addCertificate(certificateAddDTO);
    }

    @GetMapping("/details")
    public CertificateDetailDTO getCertificate(@RequestParam("certificateId") Long certificateId,
                                               @RequestParam("studentId") Long studentId) {

        return certificateService.getCertificate(certificateId, studentId);
    }

    @PutMapping("/modiftCerAuth")
    public void modifyCertificateAuthState(CertificateModifyDTO certificateModifyDTO) {

        certificateService.modifyCertificateAuthState(certificateModifyDTO);
    }

    @PutMapping("/removeCertificate")
    public void removeCertificate(@PathVariable Long id) {

        certificateService.removeCertificate(id);
    }

}
