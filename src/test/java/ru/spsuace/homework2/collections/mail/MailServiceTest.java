package ru.spsuace.homework2.collections.mail;

import ru.spsuace.homework2.collections.mail.MailException;
import ru.spsuace.homework2.collections.mail.BaseMail;
import ru.spsuace.homework2.collections.mail.Email;
import ru.spsuace.homework2.collections.mail.Payment;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class MailServiceTest {
    private MailService mailService;

    @Before
    public void beforeAll(){
        mailService = new MailService();
    }

    @Test
    public void shouldAcceptAllMails() {

        Email email = new Email("Georgy","David","La");
        Payment payment = new Payment("Georgy", "David",500);
        mailService.accept(email);
        mailService.accept(payment);

        List<BaseMail> mails = mailService.getMailBox().get("David");
        int expectedSize = 2;
        int actualSize = mails.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldProcessListMailAndReturnPopularSender() throws MailException {

        Email email1 = new Email("Georgy", "David", "La");
        Email email2 = new Email("Georgy", "David", "Lala");
        Email email3 = new Email("Georgy", "David", "Lalalala");
        Email email4 = new Email("David", "Georgy", "La");
        List<BaseMail> baseMails = new ArrayList<>();
        baseMails.add(email1);
        baseMails.add(email2);
        baseMails.add(email3);
        baseMails.add(email4);

        MailService.process(mailService, baseMails);
        String expectedSender = "Georgy";
        String actualSender = mailService.getPopularSender();
        assertEquals(expectedSender, actualSender);
    }

    @Test
    public void shouldProcessListMailAndReturnPopularRecipient() throws MailException {

        Email email1 = new Email("Georgy", "David", "La");
        Email email2 = new Email("Georgy", "David", "Lala");
        Email email3 = new Email("Georgy", "David", "Lalalala");
        Email email4 = new Email("David", "Georgy", "La");
        List<BaseMail> baseMails = new ArrayList<>();
        baseMails.add(email1);
        baseMails.add(email2);
        baseMails.add(email3);
        baseMails.add(email4);

        MailService.process(mailService, baseMails);
        String expectedRecipient = "David";
        String actualRecipient = mailService.getPopularRecipient();
        assertEquals(expectedRecipient, actualRecipient);
    }
}