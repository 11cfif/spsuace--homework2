package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;
import java.util.Arrays;

public class FilterNegative implements TextAnalyzer{

    private Collection<String> negative = Arrays.asList("=(", ":(", ":|");

    public FilterType textAnalyzer(String text) {

        for ( String ng: negative ) {

            if (text.contains(ng)){
                return FilterType.NEGATIVE_TEXT;
            }
        }

        return FilterType.GOOD;
    }
}
