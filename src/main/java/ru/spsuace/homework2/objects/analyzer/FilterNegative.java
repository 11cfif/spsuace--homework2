package ru.spsuace.homework2.objects.analyzer;

public class FilterNegative implements TextAnalyzer {
    final FilterType filter = FilterType.NEGATIVE_TEXT;
    String[] negative = {"=(", ":(", ":|",};

    @Override
    public FilterType getTypeFilter() {
        return filter;
    }

    @Override
    public String[] getData() {
        return negative;
    }
}
