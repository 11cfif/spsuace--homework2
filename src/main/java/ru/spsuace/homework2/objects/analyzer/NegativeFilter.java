package ru.spsuace.homework2.objects.analyzer;

import java.util.Arrays;
import java.util.Collection;

public class NegativeFilter extends Analyzing implements TextAnalyzer {

    @Override
    public FilterType doFilter(String text) {
        return AnalyzString( Arrays.asList("=(", ":(", ":|"), FilterType.NEGATIVE_TEXT, text);
    }

    @Override
    public int backId() {
        return FilterType.NEGATIVE_TEXT.getNumber();
    }
}
