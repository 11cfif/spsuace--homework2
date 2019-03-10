package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class FilterSpam implements TextAnalyzer {

    protected Collection<String> badCharacters;
    protected FilterType filterName;

    FilterSpam(Collection<String> badCharacters) {

        this.badCharacters = badCharacters;
        filterName = FilterType.SPAM;
    }

    public FilterType textAnalyzer(String text) {

        for (String character : badCharacters) {

            if (text.contains(character)) {
                return filterName;
            }
        }

        return FilterType.GOOD;
    }
}
