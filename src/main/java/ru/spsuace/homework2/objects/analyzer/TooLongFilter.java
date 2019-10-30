package ru.spsuace.homework2.objects.analyzer;

public class TooLongFilter extends Analyzer {

    private final long maxLength;

    public TooLongFilter(long maxLength) {
        this.maxLength = maxLength;
    }

    public FilterType analyze(String text) {
        if (text.length() > maxLength){
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }
}
