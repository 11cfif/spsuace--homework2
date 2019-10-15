package ru.spsuace.homework2.objects.analyzer;

public class Spam implements TextAnalyzer {

    private final String[] spam;

    public Spam(String[] spam) {
        this.spam = spam;
    }

    @Override
    public FilterType analyze(String text) {
        if (text == null || text.length() == 0) {
            return FilterType.GOOD;
        }
        for (String s : spam) {
            if (text.contains(s)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}
