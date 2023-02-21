package com.dreamtree.api.domain.mail.mapper;

import com.dreamtree.api.domain.mail.dto.AddMailDTO;
import com.dreamtree.api.domain.mail.dto.MailDTO;
import com.dreamtree.api.domain.mail.dto.MailRequestDTO;

import java.util.List;

/*** 임성현 ver.0.1 ***/
public interface MailMapper {

    // 메일 조회
    MailDTO getMail(Long id);

    // 내가 쓴 메일
    List<MailDTO> getToEmailList(MailRequestDTO mailRequestDTO);

    // 내가 보낸 메일
    List<MailDTO> getFromEmailList(MailRequestDTO mailRequestDTO);

    // 메일 쓰기
    int writeMail(AddMailDTO addMailDTO);

    // 메일 삭제
    int removeMail(List<Long> id);

    // 읽은 메일 확인
    int getCheck(Long id);

    // 내가 쓴 메일 카운트
    int getToEmailCount(String mail);

    // 내가 보낸 메일 카운트
    int getFromEmailCount(String mail);

}
