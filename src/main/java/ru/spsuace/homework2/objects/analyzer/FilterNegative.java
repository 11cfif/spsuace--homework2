package ru.spsuace.homework2.objects.analyzer;

public class FilterNegative extends FilterSpam implements TextAnalyzer {
    protected String[] badEmotions = {"=(", ":(", ":|"};
    FilterNegative() {
        super("=(", ":(", ":|");
        wordFilter = FilterType.NEGATIVE_TEXT;
    }
    public FilterType TextAnalyzer(String text) {
        for (String emotions : badEmotions) {
            if (text.contains(emotions)) {
                return wordFilter;
            }
        }
        return FilterType.GOOD;
    }
}
