package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class FilterSpam implements TextAnalyzer {
    private FilterType filterSpam = FilterType.SPAM;
    private FilterType filterGood = FilterType.GOOD;

    private Collection<String> spamWord;

    public FilterSpam(Collection<String> spamWord) {
        this.spamWord = spamWord;
    }

    @Override
    public FilterType doFilter(String str) {
        for (String word : spamWord) {
            if (str.contains(word)) {
                return filterSpam;
            }
        }
        return filterGood;
    }
}
