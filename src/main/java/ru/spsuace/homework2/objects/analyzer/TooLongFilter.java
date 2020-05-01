package ru.spsuace.homework2.objects.analyzer;

public class TooLongFilter implements TextAnalyzer {
    private final long maxLength;

    public TooLongFilter (long maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public boolean checkFlags(String text) {
        return text.length() > maxLength;
    }

    @Override
    public FilterType getType() {
        return FilterType.TOO_LONG;
    }
}