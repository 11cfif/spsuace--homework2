package ru.spsuace.homework2.objects.analyzer;

import java.util.Collection;

public class FilterSpam implements TextAnalyzer {
    protected final FilterType filter;
    protected Collection<String> str;


    public FilterSpam(Collection<String> str) {
        this.str = str;
        filter = FilterType.SPAM;
    }

    public FilterSpam(Collection<String> str, FilterType filter) {
        this.str = str;
        this.filter = filter;
    }


    @Override
    public FilterType analyzeText(String text) {
        for (String element : str) {
            if (text.contains(element)) {
                return filter;
            }
        }
        return FilterType.GOOD;
    }
}
