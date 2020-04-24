package ru.spsuace.homework2.objects.analyzer;

public class Spam implements TextAnalyzer {
    private String[] spam;

    Spam(String[] spam) {
        this.spam = spam;
    }

    @Override
    public FilterType textAnalyzer(String text) {
        for (String bad : spam) {
            if (text.contains(bad)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}
