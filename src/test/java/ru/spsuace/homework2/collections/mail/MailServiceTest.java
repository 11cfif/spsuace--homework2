package ru.spsuace.homework2.collections.mail;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MailServiceTest {
    private MailService mailService;
    private List<BaseMail> testMailList;
    private List<BaseMail> expectedMailList;
    private String expectedPopularSender;
    private String expectedPopularRecipient;

    @Before
    public void setUp() throws Exception {
        mailService = new MailService();
        testMailList = new ArrayList<>();
        expectedMailList = new ArrayList<>();
    }

    @Test
    public void oneSenderOneRecipientOneMail() {
        String testSender = "Sender";
        String testRecipient = "Recipient";

        BaseMail mail = new MessageMail(testSender, testRecipient, "text");
        testMailList.add(mail);
        expectedMailList.add(mail);

        expectedPopularSender = testSender;
        expectedPopularRecipient = testRecipient;

        MailService.process(mailService, testMailList);
        assertEquals(mailService.getPopularSender(), expectedPopularSender);
        assertEquals(mailService.getPopularRecipient(), expectedPopularRecipient);
        assertEquals(mailService.getMailBox().get(testRecipient), expectedMailList);
    }

    @Test
    public void oneSenderOneRecipientManyMails() {
        String testSender = "Sender";
        String testRecipient = "Recipient";

        for (int i = 0; i < 5; i++) {
            BaseMail mail = new MessageMail(testSender, testRecipient, "text" + i);
            testMailList.add(mail);
            expectedMailList.add(mail);
        }
        for (int i = 0; i < 5; i++) {
            BaseMail mail = new SalaryMail(testSender, testRecipient, (i + 1) * 10000);
            testMailList.add(mail);
            expectedMailList.add(mail);
        }

        expectedPopularSender = testSender;
        expectedPopularRecipient = testRecipient;

        MailService.process(mailService, testMailList);
        assertEquals(mailService.getPopularSender(), expectedPopularSender);
        assertEquals(mailService.getPopularRecipient(), expectedPopularRecipient);
        assertEquals(mailService.getMailBox().get(testRecipient), expectedMailList);
    }

    @Test
    public void ManySenderManyRecipientManyMails() {
        String testSender1 = "Sender1";
        String testSender2 = "Sender2";
        String testRecipient1 = "Recipient1";
        String testRecipient2 = "Recipient2";

        BaseMail mail1 = new MessageMail(testSender1, testRecipient1, "text1");
        testMailList.add(mail1);
        expectedMailList.add(mail1);

        BaseMail mail2 = new SalaryMail(testSender2, testRecipient2, 10000);
        testMailList.add(mail2);

        BaseMail mail3 = new SalaryMail(testSender2, testRecipient1, 20000);
        testMailList.add(mail3);
        expectedMailList.add(mail3);

        expectedPopularSender = testSender2;
        expectedPopularRecipient = testRecipient1;

        MailService.process(mailService, testMailList);
        assertEquals(mailService.getPopularSender(), expectedPopularSender);
        assertEquals(mailService.getPopularRecipient(), expectedPopularRecipient);
        assertEquals(mailService.getMailBox().get(testRecipient1), expectedMailList);
    }
}