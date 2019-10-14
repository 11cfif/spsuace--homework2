package ru.spsuace.homework2.objects.analyzer;

public class ChackToSpamText implements TextAnalyzer {

    private final String[] spam;

    public ChackToSpamText(String[] spam) {
        this.spam = spam;
    }

    @Override
    public FilterType Analyzer(String text) {

        for (String spam : spam) {
            if (text.contains(spam)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}