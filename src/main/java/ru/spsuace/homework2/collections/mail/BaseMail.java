package ru.spsuace.homework2.collections.mail;

/**
 * Класс для базового сообщения
 * 1 балл
 */
public class BaseMail {
    protected final String recipient;
    protected final String sender;

    public BaseMail(String recipient, String sender) {
        this.recipient = recipient;
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }
}
