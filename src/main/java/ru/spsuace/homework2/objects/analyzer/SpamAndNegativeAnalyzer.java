package ru.spsuace.homework2.objects.analyzer;

import java.util.Arrays;
import java.util.Collection;

public class SpamAndNegativeAnalyzer implements TextAnalyzer {
    FilterType filter;
    Collection<String> things;

    SpamAndNegativeAnalyzer() {
        this.filter = FilterType.NEGATIVE_TEXT;
        this.things = Arrays.asList("=(", ":(", ":|");
    }

    SpamAndNegativeAnalyzer(Collection<String> spam) {
        this.filter = FilterType.SPAM;
        this.things = spam;
    }

    @Override
    public FilterType analyzer(String str) {
        for (String thing : things) {
            if (str.contains(thing)) {
                return filter;
            }
        }
        return FilterType.GOOD;
    }
}
