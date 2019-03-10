package ru.spsuace.homework2.objects.analyzer;

import java.util.Arrays;
import java.util.Collection;

public class NegativeFilter extends Analyzing implements TextAnalyzer {
    private Collection<String> emoticons = Arrays.asList("=(", ":(", ":|");
    private FilterType filter = FilterType.NEGATIVE_TEXT;

    @Override
    public FilterType doFilter(String text) {
        return AnalyzString(emoticons, filter, text);
    }

    @Override
    public int backId() {
        return filter.getNumber();
    }
}
