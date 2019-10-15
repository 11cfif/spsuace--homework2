package ru.spsuace.homework2.objects.analyzer;

public class SpamAnalyzer implements TextAnalyzer {

    private String[] spamString;
    protected FilterType filter = FilterType.SPAM;

    public SpamAnalyzer(String[] spam) {
        this.spamString = spam;
        filter = FilterType.SPAM;
    }

    public SpamAnalyzer(String[] spam, FilterType type) {
        this.spamString = spam;
        filter = type;
    }

    public FilterType analyze(String text) {
        for (String str : spamString) {
            if (text.contains(str)) {
                return filter;
            }
        }
        return FilterType.GOOD;
    }

}
