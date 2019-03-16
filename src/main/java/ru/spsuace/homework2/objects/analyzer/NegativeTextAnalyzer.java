package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextAnalyzer implements TextAnalyzer {
    String smiles[] = {"=(", ":(", ":|"};
    FilterType filter = FilterType.NEGATIVE_TEXT;

    @Override
    public FilterType analyzer(String str) {
        for (String smile : smiles) {
            if (str.contains(smile)) {
                return filter;
            }
        }
        return FilterType.GOOD;
    }

}


