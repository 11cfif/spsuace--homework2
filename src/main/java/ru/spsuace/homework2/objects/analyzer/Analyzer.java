package ru.spsuace.homework2.objects.analyzer;

abstract public class Analyzer implements TextAnalyzer {

    private final FilterType FILTER;

    public Analyzer(FilterType Type) {
        this.FILTER = Type;
    }

    @Override
    public FilterType GetType() {
        return FILTER;
    }
}
