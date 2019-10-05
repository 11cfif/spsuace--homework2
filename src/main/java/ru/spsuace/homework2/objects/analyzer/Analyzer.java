package ru.spsuace.homework2.objects.analyzer;

public abstract class Analyzer implements TextAnalyzer {

    private final FilterType Type;

    public Analyzer (FilterType type) {
        Type = type;
    }

    @Override
    public FilterType GetFilterType() {
        return Type;
    }

}
