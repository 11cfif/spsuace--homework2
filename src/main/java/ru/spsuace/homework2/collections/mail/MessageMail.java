package ru.spsuace.homework2.collections.mail;

import java.util.Objects;

public class MessageMail extends BaseMail {
    private final String message;

    public MessageMail(String sender, String recipient, String message) {
        super(sender, recipient);
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
        MessageMail that = (MessageMail) o;
        return message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), message);
    }
}
