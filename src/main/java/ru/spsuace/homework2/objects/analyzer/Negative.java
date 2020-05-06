package ru.spsuace.homework2.objects.analyzer;

public class Negative implements TextAnalyzer {
    private final String[] keywords = {"=(", ":(", ":|"};



    public FilterType analyze(String text) {
        FilterType result = FilterType.GOOD;
        for (String keyword : keywords)
            if (text.contains(keyword)) {
                result = FilterType.NEGATIVE_TEXT;
                break;
            }
        return result;
    }
}