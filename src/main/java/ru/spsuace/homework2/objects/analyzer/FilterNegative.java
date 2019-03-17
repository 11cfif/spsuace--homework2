package ru.spsuace.homework2.objects.analyzer;

public class FilterNegative implements TextAnalyzer {
    private FilterType filterNegative = FilterType.NEGATIVE_TEXT;
    private FilterType filterGood = FilterType.GOOD;

    String emotions[] = {"=(", ":(", ":|"};


    @Override
    public FilterType doFilter(String str) {
        for (String smile : emotions) {
            if (str.contains(smile)) {
                return filterNegative;
            }
        }
        return filterGood;
    }
}
