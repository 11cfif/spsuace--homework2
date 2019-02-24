package ru.spsuace.homework2.objects.analyzer;

public class FilterToLong implements TextAnalyzer {
    final FilterType filter = FilterType.TOO_LONG;
    private long maxLength;

    public FilterToLong(long maxLength) {
        this.maxLength = maxLength;
    }


    @Override
    public FilterType getTypeFilter() {
        return filter;
    }

    @Override
    public Object getData() {
        return maxLength;
    }
}
