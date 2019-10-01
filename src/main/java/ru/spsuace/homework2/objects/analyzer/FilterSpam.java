package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class FilterSpam implements TextAnalyzer {
    protected String[] badWords;
    protected FilterType wordFilter;
    FilterSpam(String[] badWords) {
        this.badWords = badWords;
        wordFilter = FilterType.SPAM;
    }
    public FilterType TextAnalyzer(String text) {
        for (String world : badWords)
            if (text.contains(world)) {
                return wordFilter;
            }
        return FilterType.GOOD;
    }
}
