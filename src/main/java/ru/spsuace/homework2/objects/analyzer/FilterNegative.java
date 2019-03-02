package ru.spsuace.homework2.objects.analyzer;

import java.util.Arrays;
import java.util.Collection;

public class FilterNegative extends StringTextAnalyze implements TextAnalyzer {
    private final FilterType filter = FilterType.NEGATIVE_TEXT;
    Collection<String> negative = Arrays.asList("=(", ":(", ":|");

    @Override
    public FilterType analyzeText(String text) {
        return analyzeTextString(text, filter, negative);
    }
}
