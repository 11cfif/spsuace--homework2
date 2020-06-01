package ru.spsuace.homework2.collections.mail;

import java.util.Objects;

/**
 * Класс для базового сообщения
 * 1 балл
 */
public class BaseMail {
    private final String sender;
    private final String recipient;

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