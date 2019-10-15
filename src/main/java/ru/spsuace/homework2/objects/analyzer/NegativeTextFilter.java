package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextFilter implements TextAnalyzer {

    private static final String[] negativeText = {"=(", ":(", ":|"};

    @Override
    public FilterType Analyze(String text) {
        if (text == null || text.length() == 0) {
            return FilterType.GOOD;
        }

        for (String negativeText : negativeText) {
            if (text.contains(negativeText)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }

        return FilterType.GOOD;
    }
}