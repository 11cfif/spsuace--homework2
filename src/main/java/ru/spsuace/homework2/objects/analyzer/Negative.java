package ru.spsuace.homework2.objects.analyzer;

public class Negative implements TextAnalyzer{

    private final String[] negative = new String[] {"=(", ":(", ":|"};

    @Override
    public FilterType analyze(String text) {
        if (text == null || text.length() == 0) {
            return FilterType.GOOD;
        }
        for (String s : negative) {
            if (text.contains(s)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }
}
