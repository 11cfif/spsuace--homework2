package ru.spsuace.homework2.objects.analyzer;

public class TooLongAnalyzer implements TextAnalyzer {
    long maxLength;
    FilterType filter = FilterType.TOO_LONG;

    public TooLongAnalyzer(long maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public FilterType analyzer(String str) {
        if (str.length() >= maxLength) {
            return filter;
        }
        return FilterType.GOOD;
    }
}
