package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class SpamAnalyzer implements TextAnalyzer {
    FilterType filter = FilterType.SPAM;
    Collection<String> spam;

    SpamAnalyzer(Collection<String> spam) {
        this.spam = spam;
    }

    @Override
    public FilterType analyzer(String str) {
        for (String word : spam) {
            if (str.contains(word)) {
                return filter;
            }
        }
        return FilterType.GOOD;
    }
}

