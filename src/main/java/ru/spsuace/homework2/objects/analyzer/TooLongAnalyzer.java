package ru.spsuace.homework2.objects.analyzer;

public class TooLongAnalyzer implements TextAnalyzer {

    final private long maxLength;
    private final int priority = 2;

    public TooLongAnalyzer(long maxLength) {
        this.maxLength = maxLength;
    }

    public FilterType analyze(String text) {
        if (text == null || text.isEmpty()) {
            return FilterType.GOOD;
        }
        if (text.length() > maxLength) {
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }

    public int getPriority() {
        return priority;
    }
}

