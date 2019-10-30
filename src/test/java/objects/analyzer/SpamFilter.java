package ru.spsuace.homework2.objects.analyzer;

import java.util.Arrays;
import java.util.Collection;

public class SpamFilter implements TextAnalyzer {
    private Collection<String> spam;

    public SpamFilter(String[] spam) {
        this.spam = Arrays.asList(spam);
    }

    @Override
    public FilterType newFilter(String text) {
        for (String item : spam) {
            if (text.contains(item)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}
