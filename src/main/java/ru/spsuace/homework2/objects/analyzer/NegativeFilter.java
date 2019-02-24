package ru.spsuace.homework2.objects.analyzer;

public class NegativeFilter implements TextAnalyzer {
    private String[] emoticons = {"=(", ":(", ":|"};

    @Override
    public FilterType doFilter(String text) {
        for (String item : emoticons) {
            if (text.contains(item)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }
}
