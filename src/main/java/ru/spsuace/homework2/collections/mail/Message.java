package ru.spsuace.homework2.collections.mail;

import java.util.Objects;

public class Message extends BaseMail {
    private final String message;

    public Message(String sender, String receiver, String message) {
        super(sender, receiver);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Message that = (Message) o;
        return message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), message);
    }

}