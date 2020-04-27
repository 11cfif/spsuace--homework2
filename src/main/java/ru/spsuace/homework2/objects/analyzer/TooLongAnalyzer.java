package ru.spsuace.homework2.objects.analyzer;

public class TooLongAnalyzer implements TextAnalyzer {

    private final long lengthString;

    TooLongAnalyzer(long lengthString) {
        this.lengthString = lengthString;
    }

    @Override
    public int priority(FilterType type) {
        if (type == FilterType.TOO_LONG) {
            return 1;
        }
        return 4;
    }

    @Override
    public FilterType analyze(String text) {
        if (lengthString < text.length()) {
            return FilterType.TOO_LONG;
        }
        return null;
    }
}
