package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextAnalyzer {
    private final String[] negativeStrings;

    public NegativeTextAnalyzer() {
        negativeStrings = new String[] {"=(", ":(", ":|"};
    }

    public FilterType analyze(String text) {

        if(text == null || text.isEmpty()) {
            return FilterType.GOOD;
        }

            for (String str : negativeStrings) {

                for (int i = 0; i < text.length() - 1; i++) {
                if (str.equals(text.substring(i, i + str.length()))) {
                    return FilterType.NEGATIVE_TEXT;
                }
            }
        }

        return FilterType.GOOD;
    }
}
