package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class Analyzing implements TextAnalyzer {

    @Override
    public FilterType doFilter(String text) {
        return null;
    }

    public FilterType AnalyzString(Collection<String> collection, FilterType filerType, String text) {

        for (String item : collection) {

            if (text.contains(item)) {
                return filerType;
            }
        }
        return FilterType.GOOD;
    }

    @Override
    public int backId() {
        return 0;
    }
}
