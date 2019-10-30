package ru.spsuace.homework2.objects.analyzer;

public abstract class Analyzer implements TextAnalyzer {
    protected FilterType filter;

    public Analyzer(FilterType filter){
        this.filter = filter;
    }

    protected Analyzer() {
    }
}
