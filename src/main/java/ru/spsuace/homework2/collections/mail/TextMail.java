package ru.spsuace.homework2.collections.mail;


public class TextMail extends BaseMail {

    private final String text;

    public TextMail(String sender, String recipient, String text) {
        super(sender, recipient);
        this.text=text;
    }
    public String getText(){
        return text;
    }

}