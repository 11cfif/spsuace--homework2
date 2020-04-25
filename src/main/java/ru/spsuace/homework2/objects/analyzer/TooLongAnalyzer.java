package ru.spsuace.homework2.objects.analyzer;

public interface TooLongAnalyzer TextAnalyzer {

    private final long maxLength;

    public TooLongAnalyzer(long maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public FilterType analyze(String text) {
        FilterType result;
        result = FilterType.GOOD;
        if (text.length() > maxLength) {
            result = FilterType.TOO_LONG;
        }
        return result;
    }
}
