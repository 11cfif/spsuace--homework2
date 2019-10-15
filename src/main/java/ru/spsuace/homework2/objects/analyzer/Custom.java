package ru.spsuace.homework2.objects.analyzer;

public class Custom implements TextAnalyzer {

    private final String engLetter = "[a-zA-Z]";

    @Override
    public FilterType analyze(String text) {
        if (text == null || text.length() == 0) {
            return FilterType.GOOD;
        }
        if (!text.matches(engLetter)) {
            return FilterType.CUSTOM;
        }
        return FilterType.GOOD;
    }
}
