package ru.spsuace.homework2.objects.analyzer;

public class Negative  {
    private final static String[] negative = {"=(", ":(", ":|"};


    public FilterType TextAnalyzer(String text) {
        for (String evil : negative) {
            if (text.contains(evil)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }
}

