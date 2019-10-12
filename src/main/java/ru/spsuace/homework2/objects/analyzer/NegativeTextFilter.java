package ru.spsuace.homework2.objects.analyzer;

public class NegativeTextFilter implements TextAnalyzer {
    private String[] badEmotions = {"=(", ":(", ":|"};

    @Override
    public FilterType newFilter(String text) {
            for (String item : badEmotions) {
                if (text.contains(item)) {
                    return FilterType.NEGATIVE_TEXT;
                }
            }
            return FilterType.GOOD;
        }
    }
