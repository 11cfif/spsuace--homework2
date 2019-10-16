package ru.spsuace.homework2.objects.analyzer;

public class Length implements TextAnalyzer {
    private final long maxLength;

    public Length(long maxLength) {

        this.maxLength = maxLength;
    }

    @Override
    public FilterType analyzer(String text) {

        if (text.length() > maxLength) {
            return FilterType.TOO_LONG;
        }

        return FilterType.GOOD;
    }
}

