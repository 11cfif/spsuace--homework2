package ru.spsuace.homework2.objects.analyzer;

public class TooLong implements TextAnalyzer {
    private final long length;

    public TooLong(long length) {
        this.length = length;
    }

    @Override
    public FilterType textAnalyzer(String text) {
        System.out.println(text);
        if (text.length() > length) {
            return FilterType.TOO_LONG;
        } else {
            return FilterType.GOOD;
        }
    }
}
