package ru.spsuace.homework2.objects.analyzer;

public class FilterLong implements TextAnalyzer {

    private long MaxLength;
    private FilterType filterLong = FilterType.TOO_LONG;
    private FilterType filterGood = FilterType.GOOD;

    FilterLong(long maxLength) {
        this.MaxLength = maxLength;
    }

    @Override
    public FilterType doFilter(String str) {
        if (str.length() >= MaxLength) {
            return filterLong;
        }
        return filterGood;
    }
}
