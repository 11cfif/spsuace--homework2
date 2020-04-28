package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextAnalyzer extends SpamAnalyzer {
    private final static String[] keywords = {"=(", ":(", ":|"};

    public NegativeTextAnalyzer() {
        super(keywords);
    }

    @Override
    public FilterType getFilter() {
        return FilterType.NEGATIVE_TEXT;
    }
}