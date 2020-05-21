package ru.spsuace.homework2.collections.mail;

import ru.spsuace.homework2.collections.mail.BaseMail;

import java.util.*;

public class MailRepository {
    private List<BaseMail> mails = new ArrayList<>();

    public void saveMail(BaseMail baseMail) {
        mails.add(baseMail);
    }

    public List<BaseMail> getAllEmail() {
        return mails;
    }
}
