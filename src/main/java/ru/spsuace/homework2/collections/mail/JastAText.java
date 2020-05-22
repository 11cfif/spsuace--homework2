package ru.spsuace.homework2.collections.mail;

public class JastAText extends BaseMail {
    private final String text;

    public JastAText(String destination, String departure, String text) {
        super(destination, departure);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
