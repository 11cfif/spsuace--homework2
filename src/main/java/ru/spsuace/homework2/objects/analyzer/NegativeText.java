package ru.spsuace.homework2.objects.analyzer;

public class NegativeText implements TextAnalyzer {
    private final static String[] negative = {"=(", ":(", ":|"};

    @Override
    public FilterType textAnalyzer(String text) {
        for (String evil : negative) {
            if (text.contains(evil)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }
}