package ru.spsuace.homework2.objects.analyzer;

public class TooLongFilter implements TextAnalyzer {
    private long length;

    public TooLongFilter(long maxLength) {
        this.length = length;
    }

    @Override
    public FilterType newFilter(String text) {
        if (text.length() > length) {
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }
}

