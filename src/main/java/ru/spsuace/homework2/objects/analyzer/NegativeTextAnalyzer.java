package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextAnalyzer implements TextAnalyzer {

    private final String[] negativeStrings = new String[] {"=(", ":(", ":|"};
    private final FilterType filter = FilterType.NEGATIVE_TEXT;

    public FilterType analyze(String text) {
        for (String str : negativeStrings) {
            if (text.contains(str)) {
                return filter;
            }
        }
        return FilterType.GOOD;
    }

    public int getPriority() {
        return filter.getPriority();
    }
}
