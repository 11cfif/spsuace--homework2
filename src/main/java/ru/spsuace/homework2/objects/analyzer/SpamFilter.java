package ru.spsuace.homework2.objects.analyzer;


public class SpamFilter implements TextAnalyzer {
    private final String[] spam;
    private final FilterType response;

    protected SpamFilter(String[] spam, FilterType response) {
        this.spam = spam;
        this.response = response;
    }

    public SpamFilter(String[] spam) {
        this.spam = spam;
        this.response = FilterType.SPAM;
    }

    @Override
    public FilterType Analyze(String text) {
        if (text == null || text.length() == 0) {
            return FilterType.GOOD;
        }

        for (String spam : spam) {
            if (text.contains(spam)) {
                return response;
            }
        }

        return FilterType.GOOD;
    }
}
