package ru.spsuace.homework2.collections.mail;

/**
 * Класс для базового сообщения
 * 1 балл
 */
public class BaseMail {

    private String sender;
    private String receiver;

    public BaseMail(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }
}
