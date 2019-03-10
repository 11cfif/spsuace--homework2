package ru.spsuace.homework2.objects.analyzer;

public class TooLongFilter implements TextAnalyzer {
    private long masLenght;
    private FilterType filter = FilterType.TOO_LONG;

    public TooLongFilter(long masLenght) {
        this.masLenght = masLenght;
    }

    @Override
    public FilterType doFilter(String text) {

        if (text.length() > masLenght) {
            return filter;
        }
        return FilterType.GOOD;
    }

    @Override
    public int backId() {
        return filter.getNumber();
    }
}
