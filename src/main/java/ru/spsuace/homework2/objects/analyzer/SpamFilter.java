package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class SpamFilter extends Analyzing {
    private Collection<String> spamList;
    private FilterType filter = FilterType.SPAM;

    public SpamFilter(Collection<String> spamList) {
        this.spamList = spamList;
    }

    @Override
    public FilterType doFilter(String text) {

        return AnalyzString(spamList, filter, text);
    }

    @Override
    public int backId() {
        return filter.getNumber();
    }
}
