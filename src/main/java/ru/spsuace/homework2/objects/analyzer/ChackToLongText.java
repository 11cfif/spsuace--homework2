package ru.spsuace.homework2.objects.analyzer;

public class ChackToLongText implements TextAnalyzer {

    private final long maximumLength;

    ChackToLongText(long maxLength) {
        this.maximumLength = maxLength;
    }

    @Override
    public FilterType Analyzer(String text) {

        if (text.length() >  maximumLength) {
            return FilterType.TOO_LONG;
        }
        return  FilterType.GOOD;
    }
}
