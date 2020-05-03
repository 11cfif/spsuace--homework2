package ru.spsuace.homework2.objects.analyzer;

public class NEGATIVE_TEXT implements TextAnalyzer {
    String[] emoji = {"=(", ":(", ":|"};

    @Override
    public FilterType analyze(String text) {
        if (text != null) {
            for (String emoji : emoji) {

                if (text.contains(emoji)) {
                    return FilterType.NEGATIVE_TEXT;
                }
            }
        }
        return null;

    }
}