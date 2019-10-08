package ru.spsuace.homework2.objects.analyzer;


public class SpamFilter implements TextAnalyzer {
    protected String[] spam;
    protected FilterType FilterWords;

    public SpamFilter(String[] spam) {
        this.spam = spam;
        FilterWords = FilterType.SPAM;
    }

    protected SpamFilter(String[] spam, FilterType FilterWords) {
        this(spam);
        this.FilterWords = FilterWords;
    }

    @Override
    public FilterType textAnalyzer(String text) {
        for (String item : spam) {
            if (text.contains(item)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}
