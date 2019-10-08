package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextAnalyzer implements TextAnalyzer {

    private final String[] negativeStrings = new String[] {"=(", ":(", ":|"};
    private final int priority = 3;

    public FilterType analyze(String text) {
        for (String str : negativeStrings) {
            if (text.contains(str)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }

    public int getPriority() {
        return priority;
    }
}
