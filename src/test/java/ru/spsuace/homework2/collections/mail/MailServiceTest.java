package ru.spsuace.homework2.collections.mail;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MailServiceTest {
    private MailService mailService;
    private List<BaseMail> test;
    private List<BaseMail> expected;


    @Before
    public void setUp() {
        mailService = new MailService();
        test = new ArrayList<>();
        expected = new ArrayList<>();
    }

    @Test
    public void oneSenderAndRecipientOneMail() {

        BaseMail mail = new TextMail("google", "opera", "Good morning");
        test.add(mail);
        expected.add(mail);

        MailService.process(mailService, test);
        assertEquals("google", mailService.getPopularSender());
        assertEquals("opera", mailService.getPopularRecipient());
        assertEquals(expected, mailService.getMailBox().get("opera"));
    }

    @Test
    public void oneSenderAndRecipientManyMails() {

        BaseMail mail = new TextMail("Sender", "Recipient", "Hello world");
        test.add(mail);
        expected.add(mail);

        BaseMail mail1 = new TextMail("Sender", "Recipient", "How are you?");
        test.add(mail1);
        expected.add(mail1);

        BaseMail mail2 = new TextMail("Sender", "Recipient", "I am fine");
        test.add(mail2);
        expected.add(mail2);

        BaseMail mail3 = new SalaryMail("Sender", "Recipient", 24858290);
        test.add(mail3);
        expected.add(mail3);

        BaseMail mail4 = new SalaryMail("Sender", "Recipient", 2);
        test.add(mail4);
        expected.add(mail4);

        BaseMail mail5 = new SalaryMail("Sender", "Recipient", 987);
        test.add(mail5);
        expected.add(mail5);

        MailService.process(mailService, test);
        assertEquals("Sender", mailService.getPopularSender());
        assertEquals("Recipient", mailService.getPopularRecipient());
        assertEquals(expected, mailService.getMailBox().get("Recipient"));
    }

    @Test
    public void ManySenderAndRecipientManyMails() {

        BaseMail mail1 = new TextMail("google", "Recipient1", "you are fired");
        test.add(mail1);
        expected.add(mail1);

        BaseMail mail2 = new SalaryMail("yandex", "Recipient2", 4579785);
        test.add(mail2);

        BaseMail mail3 = new SalaryMail("yandex", "Recipient1", 923857);
        test.add(mail3);
        expected.add(mail3);


        MailService.process(mailService, test);
        assertEquals("yandex", mailService.getPopularSender());
        assertEquals("Recipient1", mailService.getPopularRecipient());
        assertEquals(expected, mailService.getMailBox().get("Recipient1"));
    }
}