package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class SpamFilter extends Analyzing {
    private Collection<String> spamList;

    public SpamFilter(Collection<String> spamList) {
        this.spamList = spamList;
    }

    @Override
    public FilterType doFilter(String text) {
        return analyzString(spamList, FilterType.SPAM, text);
    }

    @Override
    public int backId() {
        return FilterType.SPAM.getNumber();
    }
}
