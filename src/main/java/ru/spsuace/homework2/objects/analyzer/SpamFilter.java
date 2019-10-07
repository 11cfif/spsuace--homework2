package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class SpamFilter implements TextAnalyzer {
    private Collection<String> spam;

    public SpamFilter(Collection<String> spam) {
        this.spam = spam;
    }

    @Override
    public FilterType startFilter(String text) {
        for (String item : spam) {
            if (text.contains(item)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}
