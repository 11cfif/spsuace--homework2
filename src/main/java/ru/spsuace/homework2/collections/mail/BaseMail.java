package ru.spsuace.homework2.collections.mail;

/**
 * Класс для базового сообщения
 * 1 балл
 */
public class BaseMail {
    private final String sender;
    private String recipient;

    public BaseMail(String sender, String recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
