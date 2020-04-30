package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextAnalyzer implements TextAnalyzer {
    private static final String[] negativeKeywords = new String[] {"=(", ":(", ":|"};


    @Override
    public FilterType analyze(String text) {
        FilterType result = FilterType.GOOD;
        for (String keyword : negativeKeywords)
            if (text.contains(keyword)) {
                result = FilterType.NEGATIVE_TEXT;
                break;
            }
        return result;
    }
}
