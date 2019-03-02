package ru.spsuace.homework2.objects.analyzer;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Objects;

public abstract class StringTextAnalyze implements TextAnalyzer {


    public FilterType analyzeTextString(String text, FilterType filterType, Collection<String> str) {
        for (String element : str) {
            if (text.contains(element)) {
                return filterType;
            }
        }
        return FilterType.GOOD;
    }

    @Override
    public FilterType analyzeText(String text) {
        return null;
    }
}
