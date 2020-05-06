package ru.spsuace.homework2.objects.analyzer;

public class Long implements TextAnalyzer {

    private final long maxLength;

    public Long(long maxLength) {
        this.maxLength = maxLength;
    }


    public FilterType analyze(String text) {
        FilterType result;
        result = FilterType.GOOD;
        if (text.length() > maxLength) {
            result = FilterType.TOO_LONG;
        }
        return result;
    }
}
