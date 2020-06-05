package ru.spsuace.homework2.collections.mail;

import java.util.Objects;

/**
 * Класс для базового сообщения
 * 1 балл
 */
public class BaseMail {
    private final String sender;
    private final String receiver;

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





    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseMail baseMail = (BaseMail) o;
        return sender.equals(baseMail.sender) && receiver.equals(baseMail.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, receiver);
    }
}