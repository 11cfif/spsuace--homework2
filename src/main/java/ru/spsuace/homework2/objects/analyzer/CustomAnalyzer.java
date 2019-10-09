package ru.spsuace.homework2.objects.analyzer;

public class CustomAnalyzer extends Analyzer {
    //проверка на ALL CAPS

    public CustomAnalyzer(FilterType filter) {
        super(filter);
    }

    public FilterType analyze(String text) {
        if (text.equals(text.toUpperCase())) {
            return filter;
        }
        return FilterType.GOOD;
    }
}
