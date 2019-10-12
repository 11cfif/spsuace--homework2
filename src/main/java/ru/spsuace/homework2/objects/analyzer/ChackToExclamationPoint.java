package ru.spsuace.homework2.objects.analyzer;

public class ChackToExclamationPoint implements TextAnalyzer {

    private final String symbol = "!";


    @Override
    public FilterType Analyzer(String text) {
        if (text.contains(symbol)) {
            return FilterType.CUSTOM;
        }
        return FilterType.GOOD;
    }
}
