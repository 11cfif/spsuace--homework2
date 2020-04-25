package ru.spsuace.homework2.objects.analyzer;

public class SpamAnalyze extends NegativeAnalyze {

    private final String[] keywords;

    public SpamAnalyze(String[] spam) {
        this.keywords = spam;
    }

    @Override
    public FilterType analyze(String text) {
        return FilterType.SPAM;
    }
}