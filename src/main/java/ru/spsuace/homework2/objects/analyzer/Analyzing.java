package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public abstract class Analyzing implements TextAnalyzer {

    public FilterType AnalyzString(Collection<String> collection, FilterType filerType, String text) {

        for (String item : collection) {

            if (text.contains(item)) {
                return filerType;
            }
        }
        return FilterType.GOOD;
    }

}
