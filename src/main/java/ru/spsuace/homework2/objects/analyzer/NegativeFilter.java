package ru.spsuace.homework2.objects.analyzer;

import java.util.Arrays;
import java.util.Collection;

public class NegativeFilter extends Analyzing {
    Collection<String> emoticons = Arrays.asList("=(", ":(", ":|");

    @Override
    public FilterType doFilter(String text) {
        return analyzString(emoticons, FilterType.NEGATIVE_TEXT, text);
    }

    @Override
    public int getFilterNumber() {
        return FilterType.NEGATIVE_TEXT.getNumber();
    }
}
