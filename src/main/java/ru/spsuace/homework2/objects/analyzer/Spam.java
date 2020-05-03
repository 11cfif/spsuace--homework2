package ru.spsuace.homework2.objects.analyzer;


public class Spam implements TextAnalyzer {
    private final String[] spam;

    Spam(String[] spam) {
        this.spam = spam;
    }

    @Override
    public FilterType analyze(String text) {
        for (String badSymb : spam) {
            if (text.contains(badSymb)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}