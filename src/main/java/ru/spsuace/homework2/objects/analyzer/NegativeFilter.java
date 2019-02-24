package ru.spsuace.homework2.objects.analyzer;

public class NegativeFilter implements TextAnalyzer{
    private String[] emoticons = {"=(", ":(", ":|"};
    private FilterType filter = FilterType.NEGATIVE_TEXT;

    @Override
    public String[] getItem() {
        return emoticons;
    }

    @Override
    public FilterType getFilterType() {
        return filter;
    }
}