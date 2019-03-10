package ru.spsuace.homework2.objects.analyzer;

public class FilterToLong implements TextAnalyzer {
    private final FilterType filter = FilterType.TOO_LONG;
    private long maxLength;

    public FilterToLong(long maxLength) {
        this.maxLength = maxLength;
    }


    @Override
    public FilterType analyzeText(String text) {
        if (text.length() > maxLength) {
            return filter;
        }
        return FilterType.GOOD;
    }
    @Override
    public int getId() {
        return filter.getNumber();
    }
}
