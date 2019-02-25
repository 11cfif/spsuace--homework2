package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class FilterSpam implements TextAnalyzer {
    private final FilterType filter = FilterType.SPAM;
    private Collection<String> spam;

    public FilterSpam(Collection<String> spam) {
        this.spam = spam;
    }


    @Override
    public FilterType analyzeText(String text) {
        for (String spamWord : spam) {
            if (text.contains(spamWord)) {
                return filter;
            }
        }
        return FilterType.GOOD;
    }
}
