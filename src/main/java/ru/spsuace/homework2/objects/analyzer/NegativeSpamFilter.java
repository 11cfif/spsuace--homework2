package ru.spsuace.homework2.objects.analyzer;

public class NegativeSpamFilter implements TextAnalyzer {
    FilterType filter;
    private final String[] negativeSpam;
    private final static String[] emotions = {"=(", ":(", ":|"};

    public NegativeSpamFilter() {
        this.filter = FilterType.NEGATIVE_TEXT;
        this.negativeSpam = emotions;
    }

    public NegativeSpamFilter(String[] spam) {
        this.filter = FilterType.SPAM;
        this.negativeSpam = spam;
    }

    @Override
    public FilterType doFilter(String str) {
        for (String thing : negativeSpam) {
            if (str.contains(thing)) {
                return filter;
            }
        }
        return FilterType.GOOD;
    }
}
