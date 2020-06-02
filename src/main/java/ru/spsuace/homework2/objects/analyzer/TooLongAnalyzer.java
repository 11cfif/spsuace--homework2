package ru.spsuace.homework2.objects.analyzer;

public class TooLongAnalyzer implements TextAnalyzer {

    private final long maxLengthWord;

    public TooLongAnalyzer(long maxLength) {
        this.maxLengthWord = maxLength;
    }

    @Override
    public FilterType analyze(String text) {
        FilterType result;
        result = FilterType.GOOD;
        if (text.length() > maxLengthWord) {
            result = FilterType.TOO_LONG;
        }
        return result;
    }
}