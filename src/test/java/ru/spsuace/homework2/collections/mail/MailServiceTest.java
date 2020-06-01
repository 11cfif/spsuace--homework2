package ru.spsuace.homework2.collections.mail;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MailServiceTest {
    private MailService s;
    private TextLetter text;
    private PaymentLetter payment;
    private TextLetter text1;
    private PaymentLetter payment1;
    private TextLetter text2;
    private PaymentLetter payment2;

    @Before
    public void setup() {
        s = new MailService();
        text = new TextLetter("Masha", "Dasha", "Hello!");
        payment = new PaymentLetter("Sasha", "Masha", 100);
    }

    @Test
    public void accept() {
        s.accept(text);
        s.accept(payment);

        assertEquals(2, s.getReceivers().size());
        assertEquals(2, s.getSenders().size());
        assertEquals(2, s.getMemory().size());
    }

    @Test
    public void process() {
        text1 = new TextLetter("Dasha", "Pasha", "Hello!");
        payment1 = new PaymentLetter("Pahsa", "Sasha", 100);
        ArrayList<BaseMail> list = new ArrayList<>(Arrays.asList(text, payment, text1, payment1));
        MailService.process(s, list);

        assertEquals(4, s.getReceivers().size());
        assertEquals(4, s.getSenders().size());
        assertEquals(4, s.getMemory().size());
    }

    @Test
    public void getPopularSender() {
        text1 = new TextLetter("Masha", "Pasha", "Hello!");
        payment1 = new PaymentLetter("Masha", "Sasha", 100);
        ArrayList<BaseMail> list = new ArrayList<>(Arrays.asList(text, payment, text1, payment1));
        MailService.process(s, list);
        assertEquals("Masha", s.getPopularSender());

        text2 = new TextLetter("Sasha", "Masha", "Hello!");;
        payment2 = new PaymentLetter("Sasha", "Dasha", 100);
        list = new ArrayList<>(Arrays.asList(text2, payment2));
        MailService.process(s, list);
        assertEquals("Sasha", s.getPopularSender());
    }

    @Test
    public void getPopularReceiver() {
        text1 = new TextLetter("Pasha", "Dasha", "Hello!");
        payment1 = new PaymentLetter("Masha", "Sasha", 100);
        ArrayList<BaseMail> list = new ArrayList<>(Arrays.asList(text, payment, text1, payment1));
        MailService.process(s, list);
        assertEquals("Dasha", s.getPopularRecipient());

        text2 = new TextLetter("Masha", "Sasha", "Hello!");;
        payment2 = new PaymentLetter("Masha", "Sasha", 100);
        list = new ArrayList<>(Arrays.asList(text2, payment2));
        MailService.process(s, list);
        assertEquals("Sasha", s.getPopularRecipient());
    }
}