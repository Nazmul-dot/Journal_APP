
/*

What is Unit Test in Spring Boot?

A unit test is a type of testing where we test a small, isolated piece of code (usually a single class or method)
to verify that it works correctly.

In Spring Boot, unit testing means:

->Testing a service, controller, or component
->Without starting the full application
👉 Goal: Make sure each unit of your code behaves as expected.
 */

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
