package ru.spsuace.homework2.objects.analyzer;

public class TooLongAnalyzer implements TextAnalyzer {
    final private long maxLength;

    public TooLongAnalyzer(long maxLength) {
        this.maxLength = maxLength;
    }

    public FilterType analyze(String text) {
        if(text == null || text.isEmpty()) {
            return FilterType.GOOD;
        }
        if (text.length() > maxLength) {
            return FilterType.TOO_LONG;
        } else {
            return FilterType.GOOD;
        }
    }
}
