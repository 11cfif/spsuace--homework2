package ru.spsuace.homework2.collections.mail;

public class Email extends BaseMail{
    private String message;

    public Email(String sender, String recipient, String message) {
        super(sender, recipient);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
