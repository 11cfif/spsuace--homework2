package ru.spsuace.homework2.objects.analyzer;

public class CustomAnalyzer implements TextAnalyzer {
    //проверка на ALL CAPS

    private final FilterType filter = FilterType.CUSTOM;

    public FilterType analyze(String text) {
        if (text.equals(text.toUpperCase())) {
            return filter;
        }
        return FilterType.GOOD;
    }

    public int getPriority() {
        return filter.getPriority();
    }
}
