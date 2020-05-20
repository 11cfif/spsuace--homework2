package ru.spsuace.homework2.collections.mail;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MailServiceTest {
    private static final String RECIPIENT = "recipient@mail.ru";
    private static final String SENDER = "sender@mail.ru";
    private static final List<BaseMail> MAILS = Arrays.asList(new TextMail(RECIPIENT, SENDER, "Привет"),
            new SalaryMail(RECIPIENT, "sendertwo@mail.ru", 20000),
            new TextMail("recipienttwo@mail.ru", SENDER, "Как дела?"));


    @Test
    public void recipientMailsTest() {
        MailService mailService = new MailService();

        MailService.process(mailService, MAILS);

        Assert.assertTrue(mailService.getMailBox().containsKey(RECIPIENT));
        Assert.assertEquals(2, mailService.getMailBox().get(RECIPIENT).size());
    }

    @Test
    public void senderPopularityTest() {
        MailService mailService = new MailService();

        MailService.process(mailService, MAILS);

        Assert.assertEquals(SENDER, mailService.getPopularSender());
    }

    @Test
    public void recipientPopularityTest() {
        MailService mailService = new MailService();

        MailService.process(mailService, MAILS);

        Assert.assertEquals(RECIPIENT, mailService.getPopularRecipient());
    }
}
