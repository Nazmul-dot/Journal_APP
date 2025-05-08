package com.example.BasicToAdvance;


import com.example.BasicToAdvance.User.Service.CustomMailSender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SendMailTest {

    @Autowired
    private CustomMailSender mailSender;

    @Test
    public void testMail() {
        try
        {
            mailSender.SendMail("shakil01621154843@gmail.com","test sub", "test");
        }
        catch (Exception e)
        {
            log.error("mailing error",e.getMessage());
        }
    }
}
