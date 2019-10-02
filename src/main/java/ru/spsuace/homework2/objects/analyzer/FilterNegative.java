package ru.spsuace.homework2.objects.analyzer;

public class FilterNegative extends FilterSpam {
    private static String[] badEmotions = {"=(", ":(", ":|"};

    public FilterNegative() {
        super(badEmotions, FilterType.NEGATIVE_TEXT);
    }
}
