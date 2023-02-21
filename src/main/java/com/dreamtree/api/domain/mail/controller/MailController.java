package com.dreamtree.api.domain.mail.controller;

import com.dreamtree.api.common.dto.PageResponseDTO;
import com.dreamtree.api.domain.mail.dto.AddMailDTO;
import com.dreamtree.api.domain.mail.dto.MailDTO;
import com.dreamtree.api.domain.mail.dto.MailRequestDTO;
import com.dreamtree.api.domain.mail.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*** 임성현 ver.0.1 ***/

@RestController
@Log4j2
@RequestMapping("api/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/{id}")
    public MailDTO getMail(@PathVariable("id") Long id) {

        mailService.checkMail(id);

        return mailService.getMail(id);
    }

    @GetMapping("/toEmail")
    public PageResponseDTO<MailDTO> getToMailList(MailRequestDTO mailRequestDTO) {

        log.info("mailRequestDTO: " + mailRequestDTO);
        log.info("mail: " + mailRequestDTO.getMail());

        return mailService.getToEmailList(mailRequestDTO);
    }

    @GetMapping("/fromEmail")
    public PageResponseDTO<MailDTO> getFromMailList(MailRequestDTO mailRequestDTO) {

        return mailService.getFromEmailList(mailRequestDTO);
    }

    @PostMapping("/writeEmail")
    public void writeMail(@RequestBody AddMailDTO addMailDTO) {

        mailService.writeMail(addMailDTO);
    }

    @PutMapping("/remove")
    public void removeMail(@RequestBody List<Long> id) {

        log.info("remove Id: " + id);

        mailService.removeMail(id);
    }
}
