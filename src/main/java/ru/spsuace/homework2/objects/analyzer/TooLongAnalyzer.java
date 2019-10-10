package ru.spsuace.homework2.objects.analyzer;

public class TooLongAnalyzer extends Analyzer {

    private final long maxLength;

    public TooLongAnalyzer(long maxLength1, FilterType filter) {
        super(filter);
        maxLength = maxLength1;
    }

    public FilterType analyze(String text) {
        if (text.length() > maxLength) {
            return filter;
        }
        return FilterType.GOOD;
    }
}
