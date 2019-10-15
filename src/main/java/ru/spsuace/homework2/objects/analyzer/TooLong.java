package ru.spsuace.homework2.objects.analyzer;

public class TooLong implements TextAnalyzer {

    private final long maxLenght;

    public TooLong(long maxLenght) {
        this.maxLenght = maxLenght;
    }

    @Override
    public FilterType analyze(String text) {
        if (text == null || text.length() == 0) {
            return FilterType.GOOD;
        }
        if (text.length() > maxLenght) {
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }
}
