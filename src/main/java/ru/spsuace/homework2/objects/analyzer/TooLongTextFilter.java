package ru.spsuace.homework2.objects.analyzer;

public class TooLongTextFilter implements TextAnalyzer {
    private final long maxLength;

    public TooLongTextFilter(long maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public FilterType Analyze(String text) {
        if (text == null || text.length() == 0) {
            return FilterType.GOOD;
        }
        if (text.length() > maxLength) {
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }
}
