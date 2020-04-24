package ru.spsuace.homework2.objects.analyzer;

class NegativeTextAnalyzer implements TextAnalyzer {

    private final static String[] negativeText = {"=(", ":(", ":|"};

    @Override
    public FilterType analyze(String text) {
        for (String bad : negativeText) {
            if (text.contains(bad)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return null;
    }
}