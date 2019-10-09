package ru.spsuace.homework2.objects.analyzer;

public class TooLongAnalyzer extends Analyzer {

    private final long maxLength;

    public TooLongAnalyzer(long maxLength, FilterType filter) {
        super(filter);
        this.maxLength = maxLength;
    }

    public FilterType analyze(String text) {
        if (text.length() > maxLength) {
            return filter;
        }
        return FilterType.GOOD;
    }
}

