package ru.spsuace.homework2.collections.mail;

import java.util.Objects;

/**
 * Класс для базового сообщения
 * 1 балл
 */
public class BaseMail {
    private String recipient;
    private String sender;


    public BaseMail(String sender, String recipient) {
        this.recipient = recipient;
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseMail baseMail = (BaseMail) o;
        return sender.equals(baseMail.sender) && recipient.equals(baseMail.recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, recipient);
    }
}