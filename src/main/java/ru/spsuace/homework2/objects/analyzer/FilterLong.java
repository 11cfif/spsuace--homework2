package ru.spsuace.homework2.objects.analyzer;

public class FilterLong implements TextAnalyzer {

    private long maxLength;

    FilterLong(long maxLength) {

        this.maxLength = maxLength;
    }

    public FilterType textAnalyzer(String text) {

        if (text.length() > maxLength) {
            return FilterType.TOO_LONG;
        }

        return FilterType.GOOD;
    }
}
