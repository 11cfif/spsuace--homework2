package ru.spsuace.homework2.objects.analyzer;

public class ChackToNegativeText implements TextAnalyzer {

    private final String[] negativeText = {"=(", ":(", ":|"};

    @Override
    public FilterType Analyzer(String text) {

        for (String negativetxt : negativeText) {
            if (text.contains(negativetxt)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }
}
