package ru.spsuace.homework2.collections.mail;

public class TextMail extends BaseMail {
    private final String text;

    public TextMail(String recipient, String sender, String text) {
        super(recipient, sender);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
