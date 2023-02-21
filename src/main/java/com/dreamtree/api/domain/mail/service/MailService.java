package com.dreamtree.api.domain.mail.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.mail.dto.AddMailDTO;
import com.dreamtree.api.domain.mail.dto.MailDTO;
import com.dreamtree.api.domain.mail.dto.MailRequestDTO;

import java.util.List;

public interface MailService {

    // 메일 조회
    MailDTO getMail(Long id);

    void checkMail(Long id);

    // 내가 쓴 메일
    PageResponseDTO<MailDTO> getToEmailList(MailRequestDTO mailRequestDTO);

    // 내가 보낸 메일
    PageResponseDTO<MailDTO> getFromEmailList(MailRequestDTO mailRequestDTO);

    // 메일 쓰기
    void writeMail(AddMailDTO addMailDTO);

    // 메일 삭제
    void removeMail(List<Long> id);

}
