package ru.spsuace.homework2.collections.mail;

import java.util.Objects;

public class TextLetter extends BaseMail {
    private String message;

    public TextLetter(String sender, String receiver, String message) {
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
        TextLetter that = (TextLetter) o;
        return message == that.message;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), message);
    }
}
