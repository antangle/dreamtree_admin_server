package com.dreamtree.api.domain.mail.service;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.mail.dto.AddMailDTO;
import com.dreamtree.api.domain.mail.dto.MailDTO;
import com.dreamtree.api.domain.mail.dto.MailRequestDTO;
import com.dreamtree.api.domain.mail.mapper.MailMapper;
import com.dreamtree.api.domain.student.dto.StudentListDTO;
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
public class MailServiceImpl implements MailService {

    private final MailMapper mailMapper;

    @Override
    public MailDTO getMail(Long id) {

        return mailMapper.getMail(id);
    }

    @Override
    public void checkMail(Long id) {

        mailMapper.getCheck(id);
    }

    @Override
    public PageResponseDTO<MailDTO> getToEmailList(MailRequestDTO mailRequestDTO) {

        List<MailDTO> list = mailMapper.getToEmailList(mailRequestDTO);

        log.info("toList: " + list);

        int count = mailMapper.getToEmailCount(mailRequestDTO.getMail());

        PageResponseDTO<MailDTO> pageResponseDTO = PageResponseDTO.<MailDTO>withAll()
                .pageRequestDTO(mailRequestDTO)
                .dtoList(list)
                .total(count)
                .build();

        log.info("toEmail: " + pageResponseDTO);

        return pageResponseDTO;
    }

    @Override
    public PageResponseDTO<MailDTO> getFromEmailList(MailRequestDTO mailRequestDTO) {

        List<MailDTO> list = mailMapper.getFromEmailList(mailRequestDTO);

        int count = mailMapper.getFromEmailCount(mailRequestDTO.getMail());

        PageResponseDTO<MailDTO> pageResponseDTO = PageResponseDTO.<MailDTO>withAll()
                .pageRequestDTO(mailRequestDTO)
                .dtoList(list)
                .total(count)
                .build();


        return pageResponseDTO;
    }

    @Override
    public void writeMail(AddMailDTO addMailDTO) {

        mailMapper.writeMail(addMailDTO);
    }

    @Override
    public void removeMail(List<Long> id) {

        mailMapper.removeMail(id);
    }
}
