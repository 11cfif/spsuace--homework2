package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class SpamFilter implements TextAnalyzer {
    private Collection<String> spamList;

    public SpamFilter(Collection<String> spamList) {
        this.spamList = spamList;
    }

    @Override
    public FilterType doFilter(String text) {

        for (String item : spamList) {
            if (text.contains(item)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}
