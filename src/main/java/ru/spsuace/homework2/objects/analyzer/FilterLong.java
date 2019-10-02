package ru.spsuace.homework2.objects.analyzer;

public class FilterLong implements TextAnalyzer {
    private long maxLenght;

    public  FilterLong(long maxLenght) {
        this.maxLenght = maxLenght;
    }

    public FilterType textAnalyzer(String text) {
        if (text.length() > maxLenght) {
            return FilterType.TOO_LONG;
        }
        return FilterType.GOOD;
    }
}
