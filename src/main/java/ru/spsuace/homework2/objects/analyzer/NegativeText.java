package ru.spsuace.homework2.objects.analyzer;

public class NegativeText implements TextAnalyzer {

    public final String[] negativtxt = {"=(", ":(", ":|"};


    @Override
    public FilterType analyzer(String text) {

        for (String n : negativtxt) {
            if (text.contains(n)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }

        return FilterType.GOOD;
    }
}
