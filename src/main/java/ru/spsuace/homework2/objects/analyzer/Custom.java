package ru.spsuace.homework2.objects.analyzer;

public class Custom implements TextAnalyzer {
    @Override
    public FilterType analyze(String text) {
        if (text == null || text.length() == 0) {
            return FilterType.GOOD;
        }
        if (!text.matches("[a-zA-Z]")) {
            return FilterType.CUSTOM;
        }
        return FilterType.GOOD;
    }
}
