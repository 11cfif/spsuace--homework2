package ru.spsuace.homework2.objects.analyzer;

import java.util.Arrays;
import java.util.Collection;

public class NegativeFilter extends Analyzing implements TextAnalyzer {
    Collection<String> emoticons = Arrays.asList("=(", ":(", ":|");

    @Override
    public FilterType doFilter(String text) {
        return analyzString(emoticons, FilterType.NEGATIVE_TEXT, text);
    }

    @Override
    public int backId() {
        return FilterType.NEGATIVE_TEXT.getNumber();
    }
}
