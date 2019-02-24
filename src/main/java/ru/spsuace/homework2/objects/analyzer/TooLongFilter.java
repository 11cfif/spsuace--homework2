package ru.spsuace.homework2.objects.analyzer;

public class TooLongFilter<T> implements TextAnalyzer {
    private FilterType filter = FilterType.TOO_LONG;
    private long maxLenght;

    public TooLongFilter(long maxLenght) {
        this.maxLenght = maxLenght;
    }

    @Override
    public Object getItem() {
        return maxLenght;
    }

    @Override
    public FilterType getFilterType() {
        return filter;
    }
}
