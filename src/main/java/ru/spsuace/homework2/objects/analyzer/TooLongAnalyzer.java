package ru.spsuace.homework2.objects.analyzer;

public class TooLongAnalyzer implements TextAnalyzer {

    private final long maxLength;

    public TooLongAnalyzer(long maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public boolean checkFilter(String text) {
        return text.length() > maxLength;
    }

    public FilterType getFilter() {
        return FilterType.TOO_LONG;
    }
}

