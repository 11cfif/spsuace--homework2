package ru.spsuace.homework2.objects.analyzer;

abstract public class Analyzer implements TextAnalyzer {

    protected FilterType filter;

    public Analyzer(FilterType filter){
        this.filter = filter;
    }

    public int getPriority(){
        return filter.getPriority();
    }

}
