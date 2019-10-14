package ru.spsuace.homework2.objects.analyzer;

public class SpamFilter implements TextAnalyzer {
    private final String[] spam;

    public SpamFilter(String[] spam) {
        this.spam = spam;
    }

    @Override
    public FilterType Analyze(String text) {
        if (text == null || text.length() == 0) {
            return FilterType.GOOD;
        }

        for (String spam : spam) {
            if (text.contains(spam)) {
                return FilterType.SPAM;
            }
        }

        return FilterType.GOOD;
    }
}
