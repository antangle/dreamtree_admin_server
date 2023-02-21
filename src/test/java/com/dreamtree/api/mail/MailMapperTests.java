package com.dreamtree.api.mail;

import com.dreamtree.api.domain.mail.mapper.MailMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class MailMapperTests {

    @Autowired(required = false)
    MailMapper mailMapper;

    @Test
    public void getMailTest() {

        log.info("get mail test");

        log.info("result: " + mailMapper.getMail(101L));
    }

}
