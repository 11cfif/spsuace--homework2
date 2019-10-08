package ru.spsuace.homework2.objects.analyzer;

public class CustomAnalyzer implements TextAnalyzer {
    //проверка на ALL CAPS

    private final int priority = 4;

    public FilterType analyze(String text) {
        if (text == null || text.isEmpty()) {
            return FilterType.GOOD;
        }
        if (text.equals(text.toUpperCase())) {
            return FilterType.CUSTOM;
        }
        return FilterType.GOOD;
    }

    public int getPriority() {
        return priority;
    }
}
