package ru.spsuace.homework2.objects.analyzer;
public class FilterNegative implements TextAnalyzer {
    String emotions[] = {"=(", ":(", ":|"};
    @Override
    public FilterType doFilter(String str) {
        for (String smile : emotions) {
            if (str.contains(smile)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }
}
