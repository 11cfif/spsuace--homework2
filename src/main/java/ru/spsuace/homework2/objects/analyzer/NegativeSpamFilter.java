package ru.spsuace.homework2.objects.analyzer;

class NegativeSpamFilter implements TextAnalyzer {
    FilterType filter;
    protected String[] negativeSpam;
    private static String[] emotions = {"=(", ":(", ":|"};

    NegativeSpamFilter() {
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
