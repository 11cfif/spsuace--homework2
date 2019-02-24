package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class SpamFilter implements TextAnalyzer{
    private Collection<String> spamList;
    private FilterType filter = FilterType.SPAM;

    SpamFilter(Collection<String> spamList) {
        this.spamList = spamList;
    }

    @Override
    public Collection<String> getItem() {
        return spamList;
    }

    @Override
    public FilterType getFilterType() {
        return filter;
    }
}
