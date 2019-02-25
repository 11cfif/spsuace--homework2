package ru.spsuace.homework2.objects.analyzer;

public class FilterNegative implements TextAnalyzer {
    private final FilterType filter = FilterType.NEGATIVE_TEXT;
    String[] negative = {"=(", ":(", ":|",};


    @Override
    public FilterType analyzeText(String text) {
        for (String smiles : negative) {
            if (text.contains(smiles)) {
                return filter;
            }
        }
        return FilterType.GOOD;
    }
}
