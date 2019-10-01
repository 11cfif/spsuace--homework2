package ru.spsuace.homework2.objects.analyzer;

public class FilterLong implements TextAnalyzer {
    public long maxLenght;

    FilterLong(long maxLenght) {
        this.maxLenght = maxLenght;
    }

    public FilterType TextAnalyzer(String text) {
        if (text.length() > maxLenght) {
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }
}
